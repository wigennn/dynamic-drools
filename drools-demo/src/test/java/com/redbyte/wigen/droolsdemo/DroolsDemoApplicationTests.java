package com.redbyte.wigen.droolsdemo;

import com.redbyte.wigen.droolsdemo.common.enums.ApprovalTypeEnum;
import com.redbyte.wigen.droolsdemo.common.enums.CompareTypeEnum;
import com.redbyte.wigen.droolsdemo.common.enums.RuleTypeEnum;
import com.redbyte.wigen.droolsdemo.core.dao.InvoiceRuleDetailMapper;
import com.redbyte.wigen.droolsdemo.core.dao.InvoiceRuleMapper;
import com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.train.TrainInvoiceDTO;
import com.redbyte.wigen.droolsdemo.core.domain.dto.rules.RuleTemplateDTO;
import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRule;
import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRuleDetail;
import com.redbyte.wigen.droolsdemo.core.service.RuleFactory;
import com.redbyte.wigen.droolsdemo.utils.DroolsUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DroolsDemoApplicationTests {

    @Autowired
    private InvoiceRuleDetailMapper invoiceRuleDetailMapper;

    @Autowired
    private InvoiceRuleMapper invoiceRuleMapper;

    @Test
    void contextLoads() {
        String rule = "package rules;\n" +
                "//dialect  \"mvel\"\n" +
                "\n" +
                "rule \"vat-invoice-rule\"\n" +
                "    when\n" +
                "    eval(true)\n" +
                "    then\n" +
                "    System.out.println(\"hello world\");\n" +
                "end\n";
        System.out.println(rule);
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(rule, ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();

//        kieSession.insert();
//        kieSession.setGlobal("");

        int fireCount = kieSession.fireAllRules();
        System.out.println(fireCount);
        kieSession.dispose();

    }

    @Test
    public void templateTest() throws Exception {

        StringWriter sw = new StringWriter();
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
//        configuration.setClassForTemplateLoading(this.getClass(), "classpath:/rules");
        String sourceCode = "package ${packageVal};\n" +
                "\n" +
                "<#list importVals as importVal>\n" +
                "import ${importVal};\n" +
                "</#list>\n" +
                "\n" +
                "rule \"rule_${ruleName}\"\n" +
                "    when\n" +
                "        ${whenVal}\n" +
                "    then\n" +
                "        ${thenVal}\n" +
                "    end\n";

        String templatePath = ResourceUtils.getURL("classpath:rules").getPath();
        configuration.setDirectoryForTemplateLoading(new File(templatePath));

//        Template template = new Template("ruleTemplate.drl", sourceCode, configuration);
        Template template = configuration.getTemplate("ruleTemplate.ftl");

        RuleTemplateDTO templateDTO = new RuleTemplateDTO();
        templateDTO.setPackageVal("testPackageName");
        templateDTO.setImportVals(Arrays.asList("testImport"));
        templateDTO.setGolbal("testGlobal");
        templateDTO.setRuleName("testRuleName");
        templateDTO.setWhenVal("testWhen");
        templateDTO.setThenVal("testThen");


        template.process(templateDTO, sw);
        sw.flush();

        System.out.println("------------StringWriter------------------\n" + sw.toString());
    }

    @Test
    public void insertInvoiceRuleDetail() {
        InvoiceRuleDetail invoiceRuleDetail = new InvoiceRuleDetail();
        invoiceRuleDetail.setCompanyId("001");
        invoiceRuleDetail.setInvoiceType("火车票");
        invoiceRuleDetail.setInvoiceField("price");
        invoiceRuleDetail.setCompareType(CompareTypeEnum.不大于.getSymbol());
        invoiceRuleDetail.setCompareVal("100");
        invoiceRuleDetail.setHandler(ApprovalTypeEnum.直接驳回.getCode());
        invoiceRuleDetail.setHint("超过公司最大火车报销金额");
        invoiceRuleDetail.setCreateTime(new Date());
        invoiceRuleDetail.setUpdateTime(new Date());

        invoiceRuleDetailMapper.insert(invoiceRuleDetail);
    }


    @Test
    public void saveRule() {

        // 获取企业票种所有规则
        List<InvoiceRuleDetail> companyInvocieRules = invoiceRuleDetailMapper
                .getCompanyInvoiceRules("001", "火车票");

        System.out.println(companyInvocieRules);

        // 生成规则
        String ruleDetail = generateRule(companyInvocieRules);

        // 保存规则表
        InvoiceRule invoiceRule = new InvoiceRule();
        invoiceRule.setCompanyId("0001");
        invoiceRule.setInvoiceType("火车票");
        invoiceRule.setRuleDetail(ruleDetail);
        invoiceRule.setCreateTime(new Date());
        invoiceRule.setUpdateTime(new Date());
        invoiceRuleMapper.insert(invoiceRule);
    }

    private String generateRule(List<InvoiceRuleDetail> ruleDetails) {
        return new RuleFactory().getRule(RuleTypeEnum.火车票.getType()).generator(ruleDetails);
    }

    public static void main(String[] args) {
//        String packageName = TrainInvoiceDTO.class.getName();
//        System.out.println(packageName);

        List<String> li = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            li.add(String.valueOf(i));
        }

        String s = li.stream().collect(Collectors.joining(","));
        System.out.println(s);
    }

    @Test
    public void getTrainInvoiceTest() {
        InvoiceRule trainRule = invoiceRuleMapper.getCompanyInvoiceRuleInfo("0001", "火车票");
        TrainInvoiceDTO trainInvoiceDTO = new TrainInvoiceDTO();
//        trainInvoiceDTO.set
        trainInvoiceDTO.setPrice("99");
        DroolsUtil.ruleExce(trainRule.getRuleDetail(), trainInvoiceDTO);
    }
}

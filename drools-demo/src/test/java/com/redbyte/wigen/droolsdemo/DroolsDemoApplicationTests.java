package com.redbyte.wigen.droolsdemo;

import com.redbyte.wigen.droolsdemo.core.domain.dto.rules.RuleTemplateDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

@SpringBootTest
class DroolsDemoApplicationTests {

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

}

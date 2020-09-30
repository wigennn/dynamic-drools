package com.redbyte.wigen.droolsdemo.core.service.impl;

import com.redbyte.wigen.droolsdemo.core.domain.dto.RuleExecResult;
import com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.train.TrainInvoiceDTO;
import com.redbyte.wigen.droolsdemo.core.domain.dto.rules.RuleTemplateDTO;
import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRuleDetail;
import com.redbyte.wigen.droolsdemo.core.service.RuleGenerator;
import com.redbyte.wigen.droolsdemo.utils.TemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 火车票规则
 * </p>
 *
 * @author wangwq
 */
@Slf4j
public class TrainInvoiceRule implements RuleGenerator {

    @Override
    public String generator(List<InvoiceRuleDetail> ruleDetails) {
        String rule = null;

        try {
            RuleTemplateDTO ruleTemplateDTO = getRuleTemplate(ruleDetails);
            rule = TemplateUtil.getRuleContentFromTemplate(ruleTemplateDTO);
        } catch (Exception e) {
            log.error("TrainInvoiceRule generator Exception: {}", e);
        }

        return rule;
    }

    @Override
    public RuleTemplateDTO getRuleTemplate(List<InvoiceRuleDetail> ruleDetails) {

        if (CollectionUtils.isEmpty(ruleDetails)) {
            throw new IllegalArgumentException("TrainInvoiceRule getRuleTemplate ruleDetails Collection is empty");
        }

        InvoiceRuleDetail ruleDetail = ruleDetails.get(0);
        String companyId = ruleDetail.getCompanyId();
        String invoiceType = ruleDetail.getInvoiceType();

        RuleTemplateDTO dto = new RuleTemplateDTO();
        dto.setPackageVal("invoice.train");
        dto.setImportVals(Arrays.asList(TrainInvoiceDTO.class.getName()));
        dto.setGlobal(RuleExecResult.class.getName() + " result");
        dto.setRuleName(invoiceType + "_" + companyId);
        dto.setWhenVal("TrainInvoiceDTO(" + whenVal(ruleDetails) + ")");
        dto.setThenVal("result.setResult(\"提示语````````````````````\", \"预警通过\");");
/*        RuleExecResult result = new RuleExecResult();
        result.setHint("提示语`````````````````````````````");
        result.setExcepHandler("预警通过");*/

        return dto;
    }

    private String whenVal(List<InvoiceRuleDetail> ruleDetails) {
        Set<String> result = new HashSet<>();
        ruleDetails.stream().forEach(x -> {
            String field = "(Integer)" + x.getInvoiceField();
            String compareType = x.getCompareType();
            String compareVal = x.getCompareVal();
            result.add(field + compareType + compareVal);
        });
        return result.stream().collect(Collectors.joining(","));
    }
}

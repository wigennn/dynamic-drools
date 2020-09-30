package com.redbyte.wigen.droolsdemo.core.service.impl;

import com.redbyte.wigen.droolsdemo.core.domain.dto.rules.RuleTemplateDTO;
import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRuleDetail;
import com.redbyte.wigen.droolsdemo.core.service.RuleGenerator;

import java.util.List;

/**
 * <p>
 * 增值税发票校验规则
 * </p>
 *
 * @author wangwq
 */
public class VatInvoiceRule implements RuleGenerator {

    @Override
    public String generator(List<InvoiceRuleDetail> ruleDetails) {

        return null;
    }

    @Override
    public RuleTemplateDTO getRuleTemplate(List<InvoiceRuleDetail> ruleDetails) {
        return null;
    }
}

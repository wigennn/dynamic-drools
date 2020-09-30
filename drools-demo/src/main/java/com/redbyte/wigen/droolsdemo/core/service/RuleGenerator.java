package com.redbyte.wigen.droolsdemo.core.service;

import com.redbyte.wigen.droolsdemo.core.domain.dto.rules.RuleTemplateDTO;
import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRuleDetail;

import java.util.List;

/**
 * <p>
 * 发票校验
 * </p>
 *
 * @author wangwq
 */
public interface RuleGenerator {

    String generator(List<InvoiceRuleDetail> ruleDetails);

    RuleTemplateDTO getRuleTemplate(List<InvoiceRuleDetail> ruleDetails);
}

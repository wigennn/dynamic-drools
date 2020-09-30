package com.redbyte.wigen.droolsdemo.core.dao;

import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRuleDetail;

public interface InvoiceRuleDetailMapper {
    int insert(InvoiceRuleDetail record);

    int insertSelective(InvoiceRuleDetail record);
}
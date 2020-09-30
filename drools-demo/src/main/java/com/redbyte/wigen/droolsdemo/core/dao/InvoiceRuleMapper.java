package com.redbyte.wigen.droolsdemo.core.dao;

import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRule;

public interface InvoiceRuleMapper {
    int insert(InvoiceRule record);

    int insertSelective(InvoiceRule record);
}
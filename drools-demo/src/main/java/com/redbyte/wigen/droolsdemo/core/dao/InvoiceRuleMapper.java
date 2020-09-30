package com.redbyte.wigen.droolsdemo.core.dao;

import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRule;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRuleMapper {
    int insert(InvoiceRule record);

    int insertSelective(InvoiceRule record);

    @Select("select * from invoice_rule where company_id=#{companyId} and invoice_type=#{invoiceType}")
    InvoiceRule getCompanyInvoiceRuleInfo(@Param("companyId") String companyId, @Param("invoiceType") String invoiceType);
}
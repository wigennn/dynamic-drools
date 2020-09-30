package com.redbyte.wigen.droolsdemo.core.dao;

import com.redbyte.wigen.droolsdemo.core.domain.entity.InvoiceRuleDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRuleDetailMapper {
    int insert(InvoiceRuleDetail record);

    int insertSelective(InvoiceRuleDetail record);

    @Select("select * from invoice_rule_detail where company_id=#{companyId} and invoice_type=#{invoiceType}")
    List<InvoiceRuleDetail> getCompanyInvoiceRules(@Param("companyId") String companyId,
                                                   @Param("invoiceType") String invoiceType);
}
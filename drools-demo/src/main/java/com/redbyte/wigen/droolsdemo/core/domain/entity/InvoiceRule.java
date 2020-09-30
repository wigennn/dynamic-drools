package com.redbyte.wigen.droolsdemo.core.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InvoiceRule {
    private Long id;

    private String companyId;

    private String invoiceType;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

    private String ruleDetail;

}
package com.redbyte.wigen.droolsdemo.core.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InvoiceRuleDetail {
    private Long id;

    private String companyId;

    private String invoiceType;

    private String invoiceField;

    private String compareType;

    private String compareVal;

    private Byte handler;

    private String hint;

    private Date createTime;

    private Date updateTime;

}
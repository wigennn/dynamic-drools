package com.redbyte.wigen.droolsdemo.core.domain.entity;

import java.util.Date;

public class InvoiceRuleDetail {
    private Long id;

    private String invoiceType;

    private String invoiceField;

    private String compateType;

    private String compareVal;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceField() {
        return invoiceField;
    }

    public void setInvoiceField(String invoiceField) {
        this.invoiceField = invoiceField;
    }

    public String getCompateType() {
        return compateType;
    }

    public void setCompateType(String compateType) {
        this.compateType = compateType;
    }

    public String getCompareVal() {
        return compareVal;
    }

    public void setCompareVal(String compareVal) {
        this.compareVal = compareVal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
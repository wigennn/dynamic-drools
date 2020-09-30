package com.redbyte.wigen.droolsdemo.core.domain.dto.invoices;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 发票基本信息
 * </p>
 *
 * @author wangwq
 */
@Data
public class BaseInvoiceDTO implements Serializable {
    private static final long serialVersionUID = -4586965596670463900L;

    /**
     * 机器编号
     */
    private String machineNum;
    /**
     * 发票代码
     */
    private String invoiceCode;
    /**
     * 发票号码
     */
    private String invoiceNum;
    /**
     * 开票日期
     */
    private String invoiceDate;
    /**
     * 校验码
     */
    private String checkCode;
    /**
     * 收款人
     */
    private String collection;
    /**
     * 复核人
     */
    private String checker;
    /**
     * 开票人
     */
    private String invoiceCreator;
}

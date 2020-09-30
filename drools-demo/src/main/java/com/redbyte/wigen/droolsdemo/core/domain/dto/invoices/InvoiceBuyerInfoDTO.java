package com.redbyte.wigen.droolsdemo.core.domain.dto.invoices;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 购买方信息
 * </p>
 *
 * @author wangwq
 */
@Data
public class InvoiceBuyerInfoDTO extends BaseInvoiceUserInfoDTO implements Serializable {
    private static final long serialVersionUID = -4778418910213222922L;

    /**
     * 密码区
     */
    private String secretCode;
}

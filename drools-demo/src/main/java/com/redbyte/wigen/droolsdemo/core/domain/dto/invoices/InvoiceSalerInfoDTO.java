package com.redbyte.wigen.droolsdemo.core.domain.dto.invoices;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
public class InvoiceSalerInfoDTO extends BaseInvoiceUserInfoDTO implements Serializable {
    private static final long serialVersionUID = -1801972962421518965L;

    /**
     * 备注信息
     */
    private String backInfo;
}

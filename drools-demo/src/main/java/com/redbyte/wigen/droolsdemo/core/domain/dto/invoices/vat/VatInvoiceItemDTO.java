package com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.vat;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 增值税发票内容子项
 * </p>
 *
 * @author wangwq
 */
@Data
public class VatInvoiceItemDTO implements Serializable {
    private static final long serialVersionUID = -3777850902778038811L;

    private String name;
    private String specificationType;
    private String unit;
    private String count;
    private String unitPrice;
    private String price;
    private String taxPercent;
    private String taxPrice;
}

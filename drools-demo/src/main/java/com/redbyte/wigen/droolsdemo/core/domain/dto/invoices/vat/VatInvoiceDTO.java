package com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.vat;

import com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.BaseInvoiceDTO;
import com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.InvoiceBuyerInfoDTO;
import com.redbyte.wigen.droolsdemo.core.domain.dto.invoices.InvoiceSalerInfoDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 增值税发票
 * </p>
 *
 * @author wangwq
 */
@Data
public class VatInvoiceDTO extends BaseInvoiceDTO implements Serializable {
    private static final long serialVersionUID = -840442699750500806L;

    /**
     * 购买方信息
     */
    private InvoiceBuyerInfoDTO buyerInfo;

    /**
     * 销售方信息
     */
    private InvoiceSalerInfoDTO salerInfo;

    /**
     * 发票内容子项
     */
    private List<VatInvoiceItemDTO> items;

    /**
     * 总计金额
     */
    private String totalPrice;

    /**
     * 总计税额
     */
    private String totalTax;

    /**
     * 价税合计
     */
    private String taxPriceTotal;
}

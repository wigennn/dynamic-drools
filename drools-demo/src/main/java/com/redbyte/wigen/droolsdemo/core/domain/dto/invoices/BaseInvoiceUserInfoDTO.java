package com.redbyte.wigen.droolsdemo.core.domain.dto.invoices;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 发票用户基本信息
 * </p>
 *
 * @author wangwq
 */
@Data
public class BaseInvoiceUserInfoDTO implements Serializable {
    private static final long serialVersionUID = -270013696155487761L;

    /**
     * 购买方名称
     */
    private String name;
    /**
     * 购买方纳税人识别号
     */
    private String taxpayerIdentityCode;
    /**
     * 地址、电话
     */
    private String addressAndPhone;
    /**
     * 开户行及账号
     */
    private String bankNameAndAccount;
}

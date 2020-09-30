package com.redbyte.wigen.droolsdemo.core.domain.dto.rules;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 规则校验dto
 * </p>
 *
 * @author wangwq
 */
@Data
public class InvoiceRuleDTO implements Serializable {
    private static final long serialVersionUID = -4725989279040723792L;

    /**
     * 票种
     */
    private String invoiceType;
    /**
     * 校验字段
     */
    private String fieldName;
    /**
     * 处理
     */
    private String handler;
    /**
     * 提示语
     */
    private String hint;
    /**
     * 比较类型
     */
    private String CompareType;
    /**
     * 比较值
     */
    private String compareValue;
}

package com.redbyte.wigen.droolsdemo.common.enums;

/**
 * <p>
 * 规则类型
 * </p>
 *
 * @author wangwq
 */
public enum RuleTypeEnum {
    火车票("1"),
    增值税电子发票("2"),
    ;

    private String type;

    RuleTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

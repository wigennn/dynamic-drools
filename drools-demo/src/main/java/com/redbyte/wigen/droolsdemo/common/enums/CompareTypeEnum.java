package com.redbyte.wigen.droolsdemo.common.enums;

/**
 * <p>
 * 比较类型
 * </p>
 *
 * @author wangwq
 */
public enum CompareTypeEnum {
    大于(">", "大于"),
    小于("<", "小于"),
    等于("==", "等于"),
    不大于("<=", "不大于"),
    不小于(">=", "不小于"),
    包含("", "包含"),
    不包含("", "不包含"),
    范围("", "范围");

    private String compareName;

    CompareTypeEnum(String symbol, String compareName) {
        this.compareName = compareName;
    }

    public String getCompareName() {
        return compareName;
    }
}

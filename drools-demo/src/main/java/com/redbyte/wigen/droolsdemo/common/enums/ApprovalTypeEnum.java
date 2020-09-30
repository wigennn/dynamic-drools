package com.redbyte.wigen.droolsdemo.common.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
public enum ApprovalTypeEnum {
    预警通过((byte) 0, "预警通过"),
    直接驳回((byte) 1, "直接驳回"),
    ;

    private byte code;
    private String desc;

    ApprovalTypeEnum(Byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

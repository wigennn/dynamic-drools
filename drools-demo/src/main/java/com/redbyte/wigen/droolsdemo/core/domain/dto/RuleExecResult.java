package com.redbyte.wigen.droolsdemo.core.domain.dto;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
public class RuleExecResult {

    private String hint;

    private String excepHandler;

    public void setResult(String hint, String excepHandler) {
        this.setHint(hint);
        this.setExcepHandler(excepHandler);
    }
}

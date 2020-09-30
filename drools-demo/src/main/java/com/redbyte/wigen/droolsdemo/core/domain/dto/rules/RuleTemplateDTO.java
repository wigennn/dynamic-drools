package com.redbyte.wigen.droolsdemo.core.domain.dto.rules;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
public class RuleTemplateDTO implements Serializable {
    private static final long serialVersionUID = 5284965387163310341L;

    private String packageVal;

    private List<String> importVals;

    private String global;

    private String ruleName;

    private String whenVal;

    private String thenVal;
}

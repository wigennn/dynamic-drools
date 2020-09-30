package com.redbyte.wigen.droolsdemo.core.service;

import com.redbyte.wigen.droolsdemo.core.service.impl.TrainInvoiceRule;
import com.redbyte.wigen.droolsdemo.core.service.impl.VatInvoiceRule;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
public class RuleFactory {

    public RuleGenerator getRule(String ruleType) {
        switch (ruleType) {
            case "1":
                return new TrainInvoiceRule();
            case "2":
                return new VatInvoiceRule();
            default:
                break;
        }

        return null;
    }
}

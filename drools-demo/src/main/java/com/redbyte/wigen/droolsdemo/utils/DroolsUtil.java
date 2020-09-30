package com.redbyte.wigen.droolsdemo.utils;

import com.redbyte.wigen.droolsdemo.core.domain.dto.RuleExecResult;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Slf4j
public class DroolsUtil {

    public static void ruleExce(String rule, Object obj) {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(rule, ResourceType.DRL);
        KieSession kieSession = kieHelper.getKieContainer().newKieSession();

        kieSession.insert(obj);
        RuleExecResult result = new RuleExecResult();
        kieSession.setGlobal("result", result);
        int fireCount = kieSession.fireAllRules();
        log.info("Fire Rules: {}", fireCount);
        log.info("执行结果:{}", result);
        kieSession.dispose();
    }
}

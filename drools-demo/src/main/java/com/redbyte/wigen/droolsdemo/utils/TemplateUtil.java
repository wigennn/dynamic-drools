package com.redbyte.wigen.droolsdemo.utils;

import com.redbyte.wigen.droolsdemo.core.domain.dto.rules.RuleTemplateDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.StringWriter;

/**
 * <p>
 * 模板工具类
 * </p>
 *
 * @author wangwq
 */
public class TemplateUtil {

    public static String getRuleContentFromTemplate(RuleTemplateDTO ruleTemplateDTO) throws Exception {

        if (ruleTemplateDTO == null) {
            throw new IllegalArgumentException("ruleTemplateDTO is null");
        }

        StringWriter sw = new StringWriter();
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
        String templatePath = ResourceUtils.getURL("classpath:rules").getPath();
        configuration.setDirectoryForTemplateLoading(new File(templatePath));

        Template template = configuration.getTemplate("ruleTemplate.ftl");
        template.process(ruleTemplateDTO, sw);
        sw.flush();

        return sw.toString();
    }
}

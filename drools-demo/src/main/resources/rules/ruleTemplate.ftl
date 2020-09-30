package ${packageVal};

<#list importVals as importVal>
import ${importVal};
</#list>

rule "rule_${ruleName}"
    when
        ${whenVal}
    then
        ${thenVal}
    end

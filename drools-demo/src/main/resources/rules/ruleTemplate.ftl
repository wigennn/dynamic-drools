package ${packageVal};

<#list importVals as importVal>
import ${importVal};
</#list>

global ${global};

rule "rule_${ruleName}"
    when
        ${whenVal}
    then
        ${thenVal}
    end

<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.domain.${classNameLower};

public class ${className} {

	<#list table.columns as column>
    private ${column.javaType} ${column.columnNameLower};
	</#list>

<@generateConstructor className/>
<@generateJavaColumns/>

}

<#macro generateJavaColumns>
	<#list table.columns as column>

	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#list>
</#macro>



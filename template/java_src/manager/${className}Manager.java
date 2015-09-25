<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.manager;

<#include "/java_imports.include">
public interface ${className}Manager {

    public int get${className}ListCount(${className} ${classNameLower});

    public List<${className}> get${className}List(${className} ${classNameLower});

    public void update${className}(${className} ${classNameLower});

    public int create${className}(String dsName, ${className} ${classNameLower});

    public void del${className}ById(Long id);

    public ${className} get${className}ById(Long id);

}


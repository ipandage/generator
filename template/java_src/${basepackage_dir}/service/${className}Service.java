<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.admin.${classNameLower};

import java.util.List;
import com.jd.common.web.result.Result;
import com.jd.sns.vip.domain.${classNameLower}.query.${className}Query;
import com.jd.sns.vip.domain.${classNameLower}.${className};

<#include "/java_imports.include">
public interface ${className}Service {

    public Integer get${className}ListCount(${className}Query ${classNameLower}Query);

    public Result get${className}List(${className}Query ${classNameLower}Query);

    public void update${className}(${className} ${classNameLower});

    public Long insert${className}(${className} ${classNameLower});

    public void delete${className}ById(Long id);

    public ${className} get${className}ById(Long id);

}


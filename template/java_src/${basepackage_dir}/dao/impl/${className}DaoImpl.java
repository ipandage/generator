<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl.${classNameLower};

import com.jd.sns.vip.common.base.dao.BaseDao;
import java.util.List;
import com.jd.sns.vip.domain.${classNameLower}.query.${className}Query;
import com.jd.sns.vip.domain.${classNameLower}.${className};
import com.jd.sns.vip.dao.${classNameLower}.${className}Dao;

<#include "/java_imports.include">
public class ${className}DaoImpl extends BaseDao implements ${className}Dao {
    @SuppressWarnings("unchecked")
    @Override
    public List<${className}> get${className}List(${className}Query ${classNameLower}Query) {
        return (List<${className}>)queryForList("${className}.get${className}List",${classNameLower}Query);
    }
    @Override
    public Integer get${className}ListCount(${className}Query ${classNameLower}Query) {
        return (Integer) queryForObject("${className}.get${className}ListCount",${classNameLower}Query);
    }

    @Override
    public void update${className}(${className} ${classNameLower}) {
        update("${className}.update${className}",${classNameLower});
    }

    @Override
    public void insert${className}(${className} ${classNameLower}) {
        insert("${className}.insert${className}",${classNameLower});
    }

    @Override
    public void delete${className}ById(Long id) {
        delete("${className}.delete${className}ById", id);
    }

    @Override
    public ${className} get${className}ById(Long id) {
        return (${className}) queryForObject("${className}.get${className}ById",id);
    }
}


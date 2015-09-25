<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.manager.admin.${classNameLower}.impl;

import java.util.List;
import com.jd.sns.vip.domain.${classNameLower}.query.${className}Query;
import com.jd.sns.vip.domain.${classNameLower}.${className};
import com.jd.sns.vip.manager.admin.${classNameLower}.${className}Manager;
import org.springframework.stereotype.Component;
import com.jd.sns.vip.dao.${classNameLower}.${className}Dao;

<#include "/java_imports.include">
@Component("${classNameLower}Manager")
public class ${className}ManagerImpl implements ${className}Manager {

    private ${className}Dao ${classNameLower}Dao;

    @Override
    public List<${className}> get${className}List(${className}Query ${classNameLower}Query) {
        return ${classNameLower}Dao.get${className}List(${classNameLower}Query);
    }

    @Override
    public Integer get${className}ListCount(${className}Query ${classNameLower}Query) {
        return ${classNameLower}Dao.get${className}ListCount(${classNameLower}Query);
    }

    @Override
    public void update${className}(${className} ${classNameLower}) {
        ${classNameLower}Dao.update${className}(${classNameLower});
    }

    @Override
    public void insert${className}(${className} ${classNameLower}) {
        ${classNameLower}Dao.insert${className}(${classNameLower});
    }

    @Override
    public void delete${className}ById(Long id) {
        ${classNameLower}Dao.delete${className}ById(id);
    }

    @Override
    public ${className} get${className}ById(Long id) {
        return ${classNameLower}Dao.get${className}ById(id);
    }

    public void set${className}Dao(${className}Dao  ${classNameLower}Dao) {
        this.${classNameLower}Dao =  ${classNameLower}Dao;
    }
}


<#include "/java_copyright.include">
<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
package ${basepackage}.service.admin.${classNameLower}.impl;

import com.guagua.vas.constants.DataSourceName;
import org.apache.log4j.Logger;

public class ${className}HandlerImpl implements ${className}Handler {

    static Logger logger = Logger.getLogger(${className}HandlerImpl.class.getName());

    static ${className}Manager manager = ${className}ManagerFactory.getInstance();

    protected String getDsName() {
            return DataSourceName.DSN_GUAGUA_GOODS_CONFIG_NEW;
    }

    @Override
    public List<${className}> get${className}List(${className} ${classNameLower}) {
        return result;
    }

    @Override
    public Integer get${className}ListCount(${className} ${classNameLower}) {
        return manager.get${className}ListCount(${classNameLower});
    }

    @Override
    public void update${className}(${className} ${classNameLower}) {
        manager.update${className}(${classNameLower});
    }

    @Override
    public Long create${className}(${className} ${classNameLower}) {
        return manager.create${className}(dsName, ${classNameLower});;
    }

    @Override
    public void del${className}ById(Long id) {
        manager.del${className}ById(id);
    }

    @Override
    public ${className} get${className}ById(Long id) {
        return manager.get${className}ById(id);
    }
}


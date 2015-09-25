<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.admin.${classNameLower};

<#include "/java_imports.include">
public class ${className}HandlerFactory {
    private ${className}HandlerFactory() {}

    private static ${className}Handler handler;

    private static boolean initialized = false;

    public static ${className}Handler getInstance() {
        if (!initialized)
            doInitialize();
        return handler;
    }

    private static synchronized void doInitialize() {
        if (!initialized) {
            handler = new ${className}HandlerImpl();
            initialized = true;
        }
    }
}


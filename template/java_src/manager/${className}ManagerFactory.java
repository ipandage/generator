<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.manager;

<#include "/java_imports.include">
public class ${className}ManagerFactory {
    private ${className}ManagerFactory() {}

    private static ${className}Manager manager;

    private static boolean initialized = false;

    public static ${className}Manager getInstance() {
        if (!initialized)
            doInitialize();
        return manager;
    }

    private static synchronized void doInitialize() {
        if (!initialized) {
            manager = new ${className}ManagerImpl();
            initialized = true;
        }
    }
}



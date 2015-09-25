<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.manager.admin.${classNameLower}.impl;

<#include "/java_imports.include">
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ${className}ManagerImpl implements ${className}Manager {

    private static Logger logger = Logger.getLogger(${className}ManagerImpl.class.getName());

    @Override
    public List<${className}> get${className}List(${className} ${classNameLower}) {
    }

    @Override
    public int get${className}ListCount(${className} ${classNameLower}) {
    }

    @Override
    public void update${className}(${className} ${classNameLower}) {
    }

    @Override
    public int create${className}(String dsName, ${className} ${classNameLower}) {
        Connection con = null;
        CallableStatement cstmt = null;
        int result = ResultStatus.FAILED;
        try {
            con = this.getDataSourceConnection(dsName);
            cstmt = con.prepareCall(CREATE_AGENT);
            cstmt.setString(1, reformAgent.getqName());
            cstmt.setLong(2, reformAgent.getUserId());
            cstmt.setLong(3, reformAgent.getParentId());
            cstmt.setBigDecimal(4, reformAgent.getStartDate());
            cstmt.setBigDecimal(5, reformAgent.getEndDate());
            cstmt.setFloat(6, reformAgent.getDiscountRate());
            cstmt.setLong(7, reformAgent.getAgentLevel());
            cstmt.setLong(8, reformAgent.getStationId());

            cstmt.registerOutParameter(9, Types.INTEGER);
            cstmt.executeUpdate();
            result = cstmt.getInt(9);
            System.out.println(" result " + result);
        } catch (Exception sqle) {
                logger.error(sqle);
        } finally {
                ConnectionManager.closeConnection(cstmt, con);
        }
        return result;
    }

    @Override
    public void del${className}ById(Long id) {
    }

}


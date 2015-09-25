<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller.${classNameLower};

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jd.sns.vip.common.util.json.JsonUtils;
import  com.jd.sns.vip.domain.${classNameLower}.${className};
import  com.jd.sns.vip.domain.${classNameLower}.query.${className}Query;
import com.jd.sns.vip.service.admin.${classNameLower}.${className}Service;
import org.springframework.ui.ModelMap;
import com.jd.common.web.result.Result;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jd.sns.vip.common.base.controller.BaseClubController;

@org.springframework.stereotype.Controller
@RequestMapping("/${classNameLower}")
public class ${className}Controller extends BaseClubController {

    private final static Logger logger = Logger.getLogger(${className}Controller.class);

    private ${className}Service ${classNameLower}Service;
    //当前模块分页数
    private int pageSize=20;

    @RequestMapping(value = "get${className}ById", method={RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String get${className}ById(String id,String forward, HttpServletRequest req, HttpServletResponse resp, ModelMap context) {
        try {
            ${className} ${classNameLower} = ${classNameLower}Service.get${className}ById(Long.valueOf(id));
            Map map = new HashMap();
            return JsonUtils.toJson(${classNameLower});
        } catch (Exception e) {
            logger.info("get${className}ById--操作失败", e);
            return "false";
        }
    }

    @RequestMapping(value = "delete${className}ById", method={RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String delete${className}ById(String id,String forward, HttpServletRequest req, HttpServletResponse resp, ModelMap context) {
        try {
            ${classNameLower}Service.delete${className}ById(Long.valueOf(id));
            return "true";
        } catch (Exception e) {
            logger.info("delete${className}ById--操作失败", e);
            return "false";
        }
    }

    /**
     * ajax 数据更新
     */
    @RequestMapping(value = "updateAjax${className}", method={RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String updateAjax${className}(${className} ${classNameLower},String forward, HttpServletRequest req, HttpServletResponse resp, ModelMap context) {
        try {
            //取erp账号
            String operator = getPin(req);
            if (operator == null) {
                operator = "nologin";
            }
            String lastperson = operator;
            if (${classNameLower}.getId() != null) {
                ${classNameLower}Service.update${className}(${classNameLower});
            } else {
                ${classNameLower}.setCreated(new Date());
                ${classNameLower}Service.insert${className}(${classNameLower});
            }
            return "true";
        } catch (Exception e) {
            logger.info("更新失败", e);
            return "false";
        }
    }

    /**
     * 数据更新
     */
    @RequestMapping(value = "update${className}", method={RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String update${className}(${className} ${classNameLower},String forward, HttpServletRequest req, HttpServletResponse resp, ModelMap context) {
        try {
            ${classNameLower}Service.update${className}(${classNameLower});
            return "true";
        } catch(Exception e) {
            logger.info("更新失败",e);
            return "false";
        }
    }

    /**
     * 批量删除
     * @param ids
     * @param req
     * @param resp
     * @param context
     * @return
     */
    @RequestMapping(value = "update${className}Bat",method={RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody String update${className}Bat(String ids,HttpServletRequest req, HttpServletResponse resp, ModelMap context){
        try {
            if (ids == null) {
                return "请至少选中一项";
            }
            if (logger.isDebugEnabled()) {
                logger.debug(ids);
            }
            if (ids.length()>0) {
                String[] idss = ids.split(",");
                for (String id :idss) {
                    ${className} ${classNameLower} = new ${className}();
                    ${classNameLower}.setId(Long.valueOf(id));
                    ${classNameLower}Service.update${className}(${classNameLower});
                }
            }
            return "true";
        } catch (Exception e) {
            logger.info("批量删除失败",e);
        }
        return "false";
    }

    /**
     * 列表数据
     * forward:转向的路径
     */
    @RequestMapping(value = "get${className}List", method={RequestMethod.POST, RequestMethod.GET})
    public String get${className}List(${className}Query ${classNameLower}Query,String forward, HttpServletRequest req, HttpServletResponse resp, ModelMap context) {
        Result result = ${classNameLower}Service.get${className}List(${classNameLower}Query);
        toVm(result, context, req);
        if (forward==null) {
            forward="/${classNameLower}/${classNameLower}List";
        }
        return forward;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    public void set${className}Service(${className}Service ${classNameLower}Service) {
        this.${classNameLower}Service = ${classNameLower}Service;
    }
}

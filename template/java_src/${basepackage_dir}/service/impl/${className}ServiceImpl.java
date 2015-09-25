<#include "/java_copyright.include">
<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
package ${basepackage}.service.admin.${classNameLower}.impl;

import java.util.List;
import com.jd.sns.vip.common.util.json.JsonUtils;
import com.jd.common.web.result.Result;
import com.jd.sns.vip.common.util.page.MysqlPaginatedArrayList;
import com.jd.sns.vip.domain.${classNameLower}.query.${className}Query;
import com.jd.sns.vip.domain.${classNameLower}.${className};
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import com.jd.sns.vip.manager.admin.${classNameLower}.${className}Manager;
import com.jd.sns.vip.service.admin.${classNameLower}.${className}Service;
import com.jd.common.util.SequenceUtil;

@Component("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service {

    private final static Logger logger = Logger.getLogger(${className}ServiceImpl.class);
    private SequenceUtil sequenceUtil;
    private ${className}Manager ${classNameLower}Manager;

    @Override
    public Result get${className}List(${className}Query ${classNameLower}Query) {
        Result result = new Result();
        try {
            MysqlPaginatedArrayList<${className}> ${classNameLower}PageList = new MysqlPaginatedArrayList<${className}>(${classNameLower}Query.getIndex(), ${classNameLower}Query.getPageSize());
            //获取总数
            int total = ${classNameLower}Manager.get${className}ListCount(${classNameLower}Query);
            ${classNameLower}PageList.setTotalItem(total);
            //起始行
            ${classNameLower}Query.setStartRow(${classNameLower}PageList.getStartRow());
            //最大长度
            ${classNameLower}Query.setEndRow(${classNameLower}PageList.getPageSize());
            //获取分页列表
            List<${className}> ${classNameLower}List = ${classNameLower}Manager.get${className}List(${classNameLower}Query);
            /**
             * TODO 业务逻辑
             */
            ${classNameLower}PageList.addAll(${classNameLower}List);

            result.setSuccess(true);
            result.addDefaultModel("list", ${classNameLower}PageList);
            result.addDefaultModel("query", ${classNameLower}Query);

        } catch (Exception e) {
            logger.error("查询get${className}List列表异常！传输参数为----" + JsonUtils.toJson(${classNameLower}Query), e);
        }
        return result;
    }

    @Override
    public Integer get${className}ListCount(${className}Query ${classNameLower}Query) {
        return ${classNameLower}Manager.get${className}ListCount(${classNameLower}Query);
    }

    @Override
    public void update${className}(${className} ${classNameLower}) {
        ${classNameLower}Manager.update${className}(${classNameLower});
    }

    @Override
    public Long insert${className}(${className} ${classNameLower}) {
        long sequence = sequenceUtil.get(com.jd.sns.vip.common.util.sequence.Sequence.VIP_SNS_VIP_VIPCLUBCATEGORYCUSTOM_SEQUENCE.getSequenceName());
        ${classNameLower}.setId(Long.valueOf(String.valueOf(sequence)));
        ${classNameLower}Manager.insert${className}(${classNameLower});
        return sequence;
    }

    @Override
    public void delete${className}ById(Long id) {
        ${classNameLower}Manager.delete${className}ById(id);
    }

    @Override
    public ${className} get${className}ById(Long id) {
        return ${classNameLower}Manager.get${className}ById(id);
    }

    public void set${className}Manager(${className}Manager ${classNameLower}Manager) {
        this.${classNameLower}Manager = ${classNameLower}Manager;
    }

    public SequenceUtil getSequenceUtil() {
        return sequenceUtil;
    }

    public void setSequenceUtil(SequenceUtil sequenceUtil) {
        this.sequenceUtil = sequenceUtil;
    }
}


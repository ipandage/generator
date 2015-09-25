<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
var ${className} = function() {
    var func = {
        init:function() {
            func.setPageEffect();
            func.bindAdd${className}Button();
            func.bindModify${className}Button();
            func.bindDelete${className}Warn();
            func.bindVipClubBeansExchangFormSubmit();
        },

        setPageEffect:function(){
            $('#ex3a').jqm({//模态框初始化
                overlay: 20,//遮罩半透明度
                closeClass: 'jqmClose',//关闭的类
                overlayClass: 'whiteOverlay',//遮罩的类
                movable: true//是否可以拖拽
            });
        },

        /**
         * 绑定表单提交
         */
        bindVipClubBeansExchangFormSubmit:function(){
            var $from = $('#${classNameLower}Form');
            vip.common.initValidate($from);
            $('#modifyButton').click(function(){
                var validate = vip.common.validatFormSubmit($from);
                if (validate) {
                    $from.ajaxSubmit({
                        type : 'POST',
                        dataType : "json",
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        success : function(result){
                            if (result == 'true') {
                                jqm.msg({
                                    w:300,
                                    type:"success",
                                    title:'提示',
                                    content:'<div>修改成功！</div><div class="mt10 t-c"><a class="btn btn-s" onclick="redirectPage()"><s><b><span>确定</span></b></s></a></div>'
                                });
                            } else {
                                jqm.msg({
                                    w:300,
                                    type:"failure",
                                    title:'提示',
                                    content:'<div>修改失败！</div><div class="mt10 t-c"><a class="btn btn-s jqmClose" ><s><b><span>确定</span></b></s></a></div>'
                                });
                            }
                        },
                        error:function(result){
                            jqm.msg({
                                w:300,
                                type:"failure",
                                title:'提示',
                                content:'<div>系统繁忙，请稍后重试！</div><div class="mt10 t-c"><a class="btn btn-s jqmClose" ><s><b><span>确定</span></b></s></a></div>'
                            });
                        }
                    });
                }
            })
        },

        /**
         * 绑定删除警告
         */
        bindDelete${className}Warn:function(){
            $('.delete${className}Button').click(function(){
                var desc = '确定删除吗？';
                jqm.confirm({
                    w:300,
                    title:'提示',
                    content:'<div>'+desc+'</div>',
                    onConfirm:func.delete${className},
                    callbackParam:$(this)
                });
            })

        },

        /**
         * 删除
         */
        delete${className}:function(id){
            if(arguments[0]) {
                var obj = arguments[0];
                var id = obj.attr('name');
                $.ajax({
                    type: "POST",
                    url:"/${classNameLower}/delete${className}ById",
                    data:{"id" : id},
                    async: false,
                    error: function(request) {
                        alert("get data failed");
                    },
                    success: function(result) {
                        if (result == 'true') {
                            jqm.msg({
                                w:300,
                                type:"success",
                                title:'提示',
                                content:'<div>删除成功！</div><div class="mt10 t-c"><a class="btn btn-s" onclick="redirectPage(1)"><s><b><span>确定</span></b></s></a></div>'
                            });
                        } else {
                            jqm.msg({
                                w:300,
                                type:"failure",
                                title:'提示',
                                content:'<div>系统繁忙，请稍后重试！</div><div class="mt10 t-c"><a class="btn btn-s jqmClose" ><s><b><span>确定</span></b></s></a></div>'
                            });
                        }
                    }
                });
            }
        },

        /**
         * 绑定修改按钮
         */
        bindModify${className}Button:function(){
            $('.modify${className}Button').bind('click', function() {
                var id = $(this).attr('name');
                $.ajax({
                    type: "POST",
                    url:"/${classNameLower}/get${className}ById",
                    data:{"id" : id},
                    async: false,
                    error: function(request) {
                        alert("get data failed");
                    },
                    success: function(data) {
                        // 渲染数据
                        var ${classNameLower} = eval("(" + data + ")");
                        <#list table.columns as column>
                        $('#${column.columnNameLower}').val(${classNameLower}.${column.columnNameLower});
                        </#list>
                        $('#ex3a').jqmShow();
                    }
                });
            });
        },

        /**
         * 绑定继续添加按钮
         */
        bindAdd${className}Button:function(){
            $('#add${className}Button').bind('click', function() {
                $('#vipClubBeansExchangForm')[0].reset();
                $('#ex3a').jqmShow();//模态框打开，jqmShow()为模态框关闭
            });
        }
    }

    func.init();
};

$().ready(function() {
    new ${className}();
    $('#menu li a').toggleClass('closed').toggleClass('open').next('ul').slideToggle();
    $('.grid').tableCheck();//表格复选
});

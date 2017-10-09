<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>国际寄件系统</title>

    <!--适配IE -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 适配移动端 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <%@ include file="/resources/common/common.jsp" %>
    <link href="${ctxPath}/resources/css/plugins/bootstrap-table.css" rel="stylesheet" type="text/css">
    <script src="${ctxPath}/resources/js/plugins/bootstrap-table.js"></script>
    <script src="${ctxPath}/resources/js/plugins/bootstrap-table-zh-CN.min.js"></script>
    <script src="${ctxPath}/resources/js/plugins/bootstrap-table-export.js"></script>
    <script src="${ctxPath}/resources/js/plugins/tableExport.js"></script>

    <script type="text/javascript">
        $(function () {

            jQuery.support.placeholder = false;
            test = document.createElement('input');
            if ('placeholder' in test) jQuery.support.placeholder = true;
            if (!$.support.placeholder) {
                $('.field').find ('label').show ();
            }

            //根据窗口调整表格高度
            $(window).resize(function () {
                $('#mytab').bootstrapTable('resetView', {
                    height: tableHeight()
                })
            });

            //生成用户数据
            $('#mytab').bootstrapTable({
                method: 'post',
                dataType:'json',
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",//必须要有！！！！
                url: "${ctxPath}/findAll.htm",//要请求数据的文件路径
                cache:false,//禁用ajax缓存
                height: tableHeight(),//高度调整
//                toolbar: '#toolbar',//指定工具栏
//                toolbar: "#exampleTableEventsToolbar",//导出excel工具栏
                striped: true, //是否显示行间隔色
                //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的
                //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
                pageNumber: 1, //初始化加载第一页，默认第一页
                pagination: true,//是否分页
                queryParamsType: '',//查询参数组织方式,''表示传入后台的是pageNumber\pageSize,'limit'表示传入后台的是limit/offset
                sidePagination: 'server',//指定服务器端分页
                pageSize: 10,//单页记录数
                pageList: [5, 10, 20, 30],//分页步进值
                queryParams: function(params) {
                    return {
                        //每页多少条数据
                        pageSize: params.pageSize,
                        //请求第几页
                        pageNumber: params.pageNumber,
                        kUserName: $('#kUserName').val(),
                        kPhone: $('#kPhone').val()
                    }
                },//请求服务器时所传的参数
                searchOnEnterKey:true,//按回车触发搜索方法
                showRefresh: false,//刷新按钮
                showColumns: false,
                clickToSelect: false,//是否启用点击选中行
//                toolbarAlign: 'right',//工具栏对齐方式
                buttonsAlign: 'right',//按钮对齐方式
                rowStyle:function(row,index){
                    //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
                    var strclass = "";
                    if (row.state == "0") {//新增
                        strclass = 'danger';//还有一个active
                    }
                    else if (row.state == "1") {//处理中
                        strclass = 'warning';//还有一个active
                    }
                    else if (row.state == "2") {//完成
                        strclass = 'success';
                    }
                    else if (row.state == "3") {//作废
                        strclass = 'active';
                    }
                    else {
                        strclass = "info"
                    }
                    return { classes: strclass }
                },
                exportDataType:'all',
//                onLoadSuccess:function(data){   //表格数据加载成功事件
//                    rowCount = data.length-1;
//                    $("#datatable").bootstrapTable('hideRow', {index:rowCount});
//                    $("#datatable td").attr("data-tableexport-msonumberformat","\@");
//                    $("#datatable tr").attr("data-tableexport-display","always");
//                },
//                onPageChange:function(number,size){  //表格翻页事件
//                    $("#datatable").bootstrapTable('hideRow', {index:rowCount});
//                    $("#datatable td").attr("data-tableexport-msonumberformat","\@");
//                    $("#datatable tr").attr("data-tableexport-display","always");
//
//                },
//                showExport: true,  //是否显示导出按钮
//                buttonsAlign:"right",  //按钮位置
//                exportTypes:['excel'],  //导出文件类型
//                Icons:'glyphicon-export',
//                exportOptions:{
//                    ignoreColumn: [0,1],  //忽略某一列的索引
//                    fileName: '总台帐报表',  //文件名称设置
//                    worksheetName: 'sheet1',  //表格工作区名称
//                    tableName: '总台帐报表',
//                    excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
//                },
                columns: [
                    {
                        title: '全选',
                        field: 'select',
                        //复选框
                        checkbox: true,
                        width: 25,
                        align: 'center',
                        valign: 'middle'
                    },
                    {
                        title: 'ID',
                        field: 'pkid',
                        visible: false
                    },
                    {
                        title: 'cardNo',
                        field: 'cardNo',
                        visible: false
                    },
                    {
                        title: '韩国/收件人',
                        field: 'kUserName',
                        sortable: true
                    },
                    {
                        title: '韩国/电话',
                        field: 'kPhone',
                        sortable: true
                    },
                    {
                        title: '韩国/地址',
                        field: 'kAddress',
                    },
                    {
                        title: '目的城市名',
                        field: 'city'
                    },
                    {
                        title: '中国/快递单号',
                        field: 'mailNoCn'
                    },
                    {
                        title: '物品明细',
                        field: 'detail'
                    },
                    {
                        title: '提交日期',
                        field: 'createTime',
                        //——修改——获取日期列的值进行转换
                        formatter: function (value, row, index) {
                            return changeDateFormat(value)
                        }
                    },
                    {
                        title: '订单状态',
                        field: 'state',
                        visible: true,
                        formatter: function (value, row, index) {
                            var resultStr = "";
                            if(value == "0") resultStr = "待处理";
                            else if(value == "1") resultStr = "处理中";
                            else if(value == "2") resultStr = "完成";
                            else if(value == "3") resultStr = "作废";
                            return resultStr;
                        }
                    },
                    {
                        title: '提交人',
                        field: 'creator',
                        visible: false
                    },
                    {
                        title: '数据状态',
                        field: 'sysState',
                        visible: false
                    },
                    {
                        title: '微信昵称',
                        field: 'weichatNo',
                        align: 'center'
                    }
                ],
                locale: 'zh-CN',//中文支持,
                responseHandler: function (res) {
                    return res;
                }
            });


            //三个参数，value代表该列的值
            function operateFormatter(value, row, index) {
                if (value == 2) {
                    return '<i class="fa fa-lock" style="color:red"></i>'
                } else if (value == 1) {
                    return '<i class="fa fa-unlock" style="color:green"></i>'
                } else {
                    return '数据错误'
                }
            }

            //格式化时间
            function changeDateFormat(cellval) {
                if (cellval != null) {
                    var date = new Date(parseInt((cellval+"").replace("/Date(", "").replace(")/", ""), 10));
                    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                    var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
                    var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
                    var seconde = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
                    return date.getFullYear() + "-" + month + "-" + currentDate + " " + hour + ":" + minute+ ":" + seconde;
                }
            }

            //查询按钮事件
            $('#search_btn').click(function () {
                $('#mytab').bootstrapTable('refresh',
                        {url: '${ctxPath}/findAll.htm',
                        query: {pageSize: 10,
                                kUserName: $('#kUserName').val(),
                                kPhone: $('#kPhone').val()}
                        }
                );
            });
            //tableHeight函数
            function tableHeight() {
                //可以根据自己页面情况进行调整
                return $(window).height() - 200;
            }


            $('#clear_btn').click(function(){
                $('#formDiv input').each(function(){
                    $(this).val("");
                });


            });


        });

    </script>


</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand">
                国际寄件系统 | 后台管理
            </a>
        </div> <!-- /container -->
    </div> <!-- /navbar-inner -->
</div> <!-- /navbar -->


<div class="panel panel-default">
    <div id='formDiv' class="panel-body form-group" style="margin-bottom:0px;">
        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">韩国/收件人：</label>

        <div class="col-sm-2">
            <input type="text" class="form-control" name="kUserName" id="kUserName"/>
        </div>

        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">韩国/电话：</label>

        <div class="col-sm-2">
            <input type="text" class="form-control" name="kPhone" id="kPhone"/>
        </div>

        <div class="col-sm-3">
            <button class="btn btn-primary" id="search_btn">查询</button>
            <button class="btn btn-primary" id="clear_btn">清空条件</button>
            <button type="button" id="download" id="btn_download" class="btn btn-primary"
                    onClick ="$('#mytab').tableExport({ type: 'excel', escape: 'false',
                    ignoreColumn: [0,1],  //忽略某一列的索引
                    fileName: '总台帐报表',  //文件名称设置
                    worksheetName: 'sheet1',  //表格工作区名称
                    tableName: '总台帐报表',
                    excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                })">数据导出</button>
        </div>
    </div>
</div>
<table id="mytab" class="table table-hover"></table>


</body>

</html>

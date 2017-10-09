<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>国际寄件系统</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <%@ include file="/resources/common/common.jsp" %>
    <script type="text/javascript">
        $(function () {

            jQuery.support.placeholder = false;
            test = document.createElement('input');
            if ('placeholder' in test) jQuery.support.placeholder = true;
            if (!$.support.placeholder) {
                $('.field').find ('label').show ();
            }

            //提交订单
            $('#submitBtn').click(function () {
                if (!checkIsValide()) {
                    return;
                }
                var dataValues = {};
                $("#formDiv input[type='text']").each(function () {
                    dataValues[this.name] = $(this).val();
                });
                $.ajax({
                    url: '${ctxPath}/saveOrder.htm',
                    type: 'post',
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    data: dataValues,
                    success: function (data) {
                        alert("提交订单成功!稍后会有客服人员联系您！");

                    },
                    error: function () {

                    }
                });


            });


        });
        //验证是否符合规范
        function checkIsValide() {
            if ($('#kUserName').val() == "") {
                alert("韩国/收件人,不能为空!");
                return false;
            }
            if ($('#kPhone').val() == "") {
                alert("韩国/电话,不能为空!");
                return false;
            }
            if ($('#kAddress').val() == "") {
                alert("韩国/地址,不能为空!");
                return false;
            }
            if ($('#city').val() == "") {
                alert("目的城市名,不能为空!");
                return false;
            }
            if ($('#mailNoCn').val() == "") {
                alert("中国/快递单号,不能为空!");
                return false;
            }
            if ($('#detail').val() == "") {
                alert("物品明细,不能为空!");
                return false;
            }
            if ($('#weichatNo').val() == "") {
                alert("微信昵称,不能为空!");
                return false;
            }
            return true;
        }


        function clearAllInput(){
            $("#formDiv input[type='text']").each(function () {
                $(this).attr("value","");
            });
        }
    </script>


</head>

<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand">
                国际寄件系统
            </a>
        </div> <!-- /container -->
    </div> <!-- /navbar-inner -->
</div> <!-- /navbar -->


<div class="account-container">
    <div class="content clearfix">
        <div>
            <h1>添加包裹</h1>

            <div id="formDiv" class="login-fields">
                <div class="field">
                    <input type="text" id="kUserName" name="kUserName" value="" placeholder="韩国/收件人：中/英/韩都可以"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="text" id="kPhone" name="kPhone" value="" placeholder="韩国/电话：中/英/韩都可以"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="text" id="kAddress" name="kAddress" value="" placeholder="韩国/地址：中/英/韩都可以"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="text" id="city" name="city" value="" placeholder="目的城市名：中/英/韩都可以"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="text" id="mailNoCn" name="mailNoCn" value="" placeholder="中国/快递单号：即发往威海的快递，用于辨别您的快递"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="text" id="detail" name="detail" value="" placeholder="物品明细：如衣服1件，鞋子1双等"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="text" id="weichatNo" name="weichatNo" value="" placeholder="微信昵称：昵称机壳，方便收款（必填）"
                           class="login username-field"/>
                </div>

            </div>

            <div class="login-actions">
                <button id="submitBtn" class="button btn btn-success btn-large">提交订单</button>
            </div>

        </div>

    </div> <!-- /content -->

</div> <!-- /account-container -->


</body>

</html>

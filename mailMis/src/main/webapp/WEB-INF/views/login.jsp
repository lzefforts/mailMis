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


            //显示修改密码
            $('#toChangeBtn').click(function () {
                $('#loginDiv').hide();
                $('#changeDiv').show();
            });

            //返回登录
            $('#toLoginBtn').click(function () {
                $('#loginDiv').show();
                $('#changeDiv').hide();
            });


            $('#changeBtn').click(function () {
                var dataValues = {};
                $("#changeDiv input[type='text'],input[type='password']").each(function () {
                    dataValues[this.name] = $(this).val();
                });
                $.ajax({
                    url: '${ctxPath}/changePwd.htm',
                    type: 'post',
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                    data: dataValues,
                    success: function (data) {
                        var dataObject = eval("("+data+")");
                        alert(dataObject.msg);
                    },
                    error: function () {

                    }
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
                国际寄件系统
            </a>
        </div> <!-- /container -->
    </div> <!-- /navbar-inner -->
</div> <!-- /navbar -->


<div class="account-container">
    <div class="content clearfix">
        <div id="loginDiv">
            <h1>管理员登录</h1>

            <form action="${ctxPath}/login.htm" method="post" id="formDiv" class="login-fields">
                <div class="field">
                    <input type="text" id="userName" name="userName" value="" placeholder="用户名"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="password" id="passWord" name="passWord" value="" placeholder="密码"
                           class="login username-field"/>
                </div>

                <input type="submit" id="submitBtn" class="btn btn-success btn-default" value="登录"/>
                <input type="button" id="toChangeBtn" class="btn btn-success btn-default" value="修改密码"/>
            </form>
        </div>
        <div id="changeDiv" style="display: none">
            <h1>管理员修改密码</h1>

            <div class="login-fields">
                <div class="field">
                    <input type="text" id="cUserName" name="cUserName" value="" placeholder="用户名"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="password" id="oldPwd" name="oldPwd" value="" placeholder="旧密码"
                           class="login username-field"/>
                </div>

                <div class="field">
                    <input type="password" id="newPwd" name="newPwd" value="" placeholder="新密码"
                           class="login username-field"/>
                </div>

                <input type="button" id="changeBtn" class="btn btn-success btn-default" value="修改密码"/>
                <input type="button" id="toLoginBtn" class="btn btn-success btn-default" value="返回登录"/>
            </div>
        </div>

    </div> <!-- /content -->

</div> <!-- /account-container -->


</body>

</html>

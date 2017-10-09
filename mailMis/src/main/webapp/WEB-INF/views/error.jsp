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


<div class="alert alert-danger">404</div>


</body>

</html>

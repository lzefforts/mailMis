<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String ctxPath = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + "/";
    request.setAttribute("basePath",basePath);
    request.setAttribute("ctxPath",ctxPath);
%>
<link href="${ctxPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctxPath}/resources/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

<link href="${ctxPath}/resources/css/font-awesome.css" rel="stylesheet">

<link href="${ctxPath}/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctxPath}/resources/css/pages/signin.css" rel="stylesheet" type="text/css">
<script src="${ctxPath}/resources/js/jquery.min.js"></script>
<script src="${ctxPath}/resources/js/bootstrap.js"></script>

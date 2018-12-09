<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EclipseLink(Jpa persistence) S MVC S security Latest Technique</title>
<c:url var="bootCss" value="css/bootstrap.min.css" />
    <link href="${bootCss}" type="text/css"
            rel="stylesheet"></link>
<c:url var="styleCss" value="css/style.css" />
    <link href="${styleCss}" type="text/css"
            rel="stylesheet"></link>
<c:url var="loginCss" value="/css/login.css" />
<link href="${loginCss}" type="text/css" rel="stylesheet"></link>
            
<c:url var="basejs" value="js/jquery-1.12.3.min.js" />
<script src="${basejs}" type="text/javascript"></script>
<c:url var="loginjs" value="js/login.js" />
<script src="${loginjs}" type="text/javascript"></script>
</head>

<body class="login_body">
<div class="login_div">
    <div class="col-xs-12 login_title">New Framework and New Tech</div>    
    <form action="<c:url value='/login'/>" method="post">
        <div class="nav">
            <div class="nav login_nav">
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>
                <div class="col-xs-4 login_username">
                    Account:
                </div>
                <div class="col-xs-6 login_usernameInput">
                    <input type="text" name="username" id="name" value="" placeholder="&nbsp;&nbsp;Account/Telephone"  onblur="javascript:ok_or_errorBylogin(this)" />
                </div>
                <div class="col-xs-1 ok_gou">
                    √
                </div>
                <div class="col-xs-1 error_cuo">
                    ×
                </div>
            </div>
            <div class="nav login_psdNav">
                <div class="col-xs-4">
                    Password:
                </div>
                <div class="col-xs-6">
                    <input type="password" name="password" id="psd" value="" placeholder="&nbsp;&nbsp;Password" onBlur="javascript:ok_or_errorBylogin(this)" />
                </div>
                <div class="col-xs-1 ok_gou">
                    √
                </div>
                <div class="col-xs-1 error_cuo">
                    ×
                </div>
            </div>
            <div class="col-xs-12 login_btn_div">
                 <input type="submit" class="sub_btn" value="Login" id="login" />            
            </div>
            <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />
        </div>
    </form>

    <div class="col-xs-12 barter_btnDiv">
        <button class="barter_btn" onClick="javascript:barter_btn(this)">No Account ? Go Registion</button>
    </div>
</div>

<div class="register_body">
    <div class="col-xs-12 register_title">Registion</div>
    <form action="" class="register" method="post">
        <div class="nav">
            <div class="nav register_nav">
                <div class="col-xs-4">
                    Account:
                </div>
                <div class="col-xs-6">
                    <input type="text" name="" id="name_r" value="" placeholder="&nbsp;&nbsp;Account/Telephone" onBlur="javascript:ok_or_errorByRegister(this)" />
                </div>
                <div class="col-xs-1 ok_gou">
                    √
                </div>
                <div class="col-xs-1 error_cuo">
                    ×
                </div>
            </div>
            <div class="nav register_psdnav">
                <div class="col-xs-4">
                    Password:
                </div>
                <div class="col-xs-6">
                    <input type="password" name="" id="psd_r" value="" placeholder="&nbsp;&nbsp;Password" onBlur="javascript:ok_or_errorByRegister(this)" />
                </div>
                <div class="col-xs-1 ok_gou">
                    √
                </div>
                <div class="col-xs-1 error_cuo">
                    ×
                </div>
            </div>
            <div class="nav register_affirm">
                <div class="col-xs-4">
                    Verify Password:
                </div>
                <div class="col-xs-6">
                    <input type="password" name="" id="affirm_psd" value="" placeholder="&nbsp;&nbsp;Verify Password" onBlur="javascript:ok_or_errorByRegister(this)" />
                </div>
                <div class="col-xs-1 ok_gou">
                    √
                </div>
                <div class="col-xs-1 error_cuo">
                    ×
                </div>
            </div>
            <div class="col-xs-12 register_btn_div">
                <input type="submit" class="sub_btn" value="Registion" id="register" />
            </div>
        </div>
    </form>
    <div class="col-xs-12 barter_register">
        <button class="barter_registerBtn" onClick="javascript:barter_btn(this)" style="">Already ? Go Back</button>
    </div>
</div>
<div style="text-align:center;">
<p>Author&nbsp;&nbsp;&nbsp;<a href="javascript:;" target="_blank">Berry</a></p>
</div>

</body>
</html>
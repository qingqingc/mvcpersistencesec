<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <c:url var="loginCss" value="/css/login.css" />
    <link href="${loginCss}" type="text/css"
            rel="stylesheet"></link>
	<%-- <link href="${pageContext.request.contextPath}/css/login.css" type="text/css"
            rel="stylesheet"></link> --%>
	<script language="javascript">
	    var a ="${pageContext.request.contextPath}";
		function login_close() {
			if (confirm("您确定要关闭本页吗？")) {
				window.opener = null;
				window.open('', '_self');
				window.close();
			} else {
				alert("login dialog has been closed!");
			}
		}
	</script>
</head>
<body onload='document.loginForm.username.focus();'>
	<h1>S mvc Security JPA(EclipseLink) Custom Login Form (XML) that
		is developed by Berry!</h1>

	<div id="login-box">
		<h3>Login with Username and Password</h3>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form name='loginForm' action="<c:url value='/login' />" method='post'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /> <input name="cancel" type="button"
						value="cancel" onclick="login_close();" /></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring mvc + jpa(eclipselink)</title>
	<script type="text/javascript">
		function update() {
			var msg = "Are you sure to logout Berry?";
			var form1 = document.getElementById("form1");
			if (confirm(msg)) {
				form1.submit();
			} else {
				alert("You have Cancelled");
			}
		}
	</script>
</head>
<body>
	Docking page. All of logic business from here.
	<c:url var="logoutUrl" value="/logout" />
	<form id="form1" action="${logoutUrl}" method="post">
		<a href="javascript:;" onclick="update();"> Log Out</a>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>
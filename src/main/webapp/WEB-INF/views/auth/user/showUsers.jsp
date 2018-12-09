<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <c:url var="authcss" value="../../css/auth/auth.css" />
    <link href="${authcss}" rel="stylesheet" type="text/css" />
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/auth/user/saveUser">
	显示系统所用户：
		<table>
			<tr>
			     <th>index</th>
			     <th>id</th>
			     <th>name</th>
			     <th>email</th>
			     <th>password</th>
			</tr>
			<c:forEach items="${usrs}" var="sta" varStatus="status">
			    <tr>
			         <td>${status.index }</td>
			         <td>${sta.id }</td>
			         <td>${sta.name }</td>
			         <td>${sta.email }</td>
			         <td>${sta.password }</td>
			    </tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
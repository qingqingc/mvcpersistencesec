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
	<form method="post" action="${pageContext.request.contextPath}/auth/role/saveResource">
		<table>
			<tr>
				<td>Name:<input type="text" name="name" /></td>
			</tr>			
			<tr>
                <td colspan="2"><input type="submit" value="submit" /></td>
            </tr>
		</table>
	</form>
</body>
</html>
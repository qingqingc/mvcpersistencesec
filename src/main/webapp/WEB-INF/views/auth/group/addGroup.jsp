<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    #divborder{height:100px;width:400px;border:1px solid #F00}
</style>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/auth/group/saveGroup">
		<table>
			<tr>
				<td>Group Name:<input type="text" name="name" /></td>
			</tr>
			<tr>
				  <td>
				  <br/>
				  请选择权限:
				  <div id="divborder">
					  <c:forEach items="${gpLst }" var="sta">
					        <label><input name="rleCheckbox" type="checkbox" value="${sta.id }" />${sta.name } </label>                                                 
	                  </c:forEach>
                  </div>
                  </td>
			</tr>			
			<tr>			
				<td colspan="2">
				<br /><br />
				<input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
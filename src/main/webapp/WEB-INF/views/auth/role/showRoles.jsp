<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show all roles</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugin/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugin/pqgrid.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/plugin/jquery-ui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/plugin/pqgrid.min.css" />
    
    <script type="text/javascript">
        $(function() {
            var tbl = $("table.rolestable");
            var obj = $.paramquery.tableToArray(tbl);
            var newObj = {width:1000, height:400, title:"Grid For test", flexWidth:false};
            newObj.dataModel = {data: obj.data};
            newObj.colModel = obj.colModel;
            newObj.pageModel = {rPP:5, type:"local"};
            $("#grid_table").pqGrid(newObj);
            tbl.css("display", "none");
        });
    </script>
</head>
<body>
    Show all roles:
    <div id="grid_table"></div>
        <table class="rolestable" style="margin:auto;">
            <tbody>
	            <tr>
	                 <th>index</th>
	                 <th>id</th>
	                 <th>name</th>
	            </tr>
	            <c:forEach items="${roleLst}" var="sta" varStatus="status">
	                <tr id = "Tr${status.index}">
	                     <td>${status.index }</td>
	                     <td>${sta.id }</td>
	                     <td>${sta.name }</td>
	                </tr>
	            </c:forEach>
	         </tbody>
        </table>
    </form>
</body>
</html>
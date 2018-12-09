<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <meta name="description" content="Berry go on." />
    <meta name="keywords" content="Berry,spring, mvc" />
    <meta name="author" content="Berry" />
    <c:url var="faviconico" value="images/dockpage/favicon.ico" />
    <link rel="shortcut icon" href="${faviconico}" />
    <c:url var="bmcss" value="css/dockpage/bootstrap.min.css" />
    <link href="${bmcss}" rel="stylesheet" type="text/css" />
    <c:url var="newcss" value="css/dockpage/new.css" />
    <link href="${newcss}" rel="stylesheet" type="text/css" />
    <c:url var="chartsGraphscss" value="css/dockpage/charts-graphs.css" /> 
    <link href="${chartsGraphscss}" rel="stylesheet" type="text/css" />
    <!-- HTML5 shiv and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
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
     <div class="container">
        <!-- Top Nav Start -->
        <div id='cssmenu'>
          <ul>
            <li class='active'>
              <a href='#'>
                <i class="fa"></i>
                Dashboard
              </a>
            </li>
            <li>
              <a href="forms.html">
                <i class="fa"></i>
                Forms
              </a>
            </li>
            <li class=''>
              <a href='#'><i class="fa"></i>Tables</a>
              <ul>
                 <li><a href='tables.html'>Tables</a></li>
                 <li><a href='pricing.html'>Pricing Plan</a></li>
                 <li><a href='timeline.html'>Timeline</a></li>
              </ul>
            </li>
            <li class="hidden-sm">
                   <a href="#"><i class="fa"></i>System Management</a>
                   <ul>
                      <li><a href='${pageContext.request.contextPath}/auth/role/addRole'>ROLE</a></li>
                      <li><a href='${pageContext.request.contextPath}/auth/role/goAddResource'>RESOURCE</a></li>
                      <li><a href='${pageContext.request.contextPath}/auth/group/goAddGroup'>GROUP</a></li>
                      <li><a href='#'>User</a>
                          <ul>
                              <li><a href='${pageContext.request.contextPath}/auth/user/goAddUser'>Add User</a></li>
                              <li><a href='${pageContext.request.contextPath}/auth/user/findAllUser'>Show Users</a></li>
                          </ul>
                      </li>
                   </ul>
            </li>
          </ul>
        </div>
        
        <div id='cssmenu2'>
          <ul>
            <li>
              <a href='#'>
                Dashboard
              </a>
            </li>
            <li>
              <a href="forms.html">
                <i></i>
                Forms
              </a>
            </li>
            <li class=''>
              <a href='#'>Tables</a>
              <ul>
                 <li><a href='tables.html'>Tables</a></li>
                 <li><a href='pricing.html'>Pricing Plan</a></li>
                 <li><a href='timeline.html'>Timeline</a></li>
              </ul>
            </li>
            <li>
                   <a href="#">System Management</a>
                   <ul>
                      <li><a href='${pageContext.request.contextPath}/auth/role/addRole'>ROLE</a></li>
                      <li><a href='${pageContext.request.contextPath}/auth/role/goAddResource'>RESOURCE</a></li>
                      <li><a href='${pageContext.request.contextPath}/auth/group/goAddGroup'>GROUP</a></li>
                      <li><a href='#'>User</a>
                          <ul>
                              <li><a href='${pageContext.request.contextPath}/auth/user/goAddUser'>Add User</a></li>
                              <li><a href='${pageContext.request.contextPath}/auth/user/findAllUser'>Show Users</a></li>
                          </ul>
                      </li>
                   </ul>
            </li>
          </ul>
        </div>
       </div>
    
    <!--  -->
    <span style="color:red">Docking page. All of logic business from here.
    name:${mankey.name} remark: ${mankey.remark} sex: ${mankey.sex}.</span>
    <c:url var="logoutUrl" value="/logout" />
    <form id="form1" action="${logoutUrl}" method="post">
        <a href="javascript:;" onclick="update();"> Log Out</a> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    
    <!--  -->
    <a href="#" data-toggle="modal" data-target="#modtestsl">
              <span class="text-white">你好</span> 
    </a>
            <!-- Modal -->
            <div class="modal fade" id="modtestsl" tabindex="-1" role="dialog" aria-hidden="true">
                <form method="post" action="${pageContext.request.contextPath}/addRole">
                         <table>
                            <tr>
                                <td>User Name:</td>
                                <td><input type="text" name="name"/></td>
                            </tr>
                             <tr>
                                <td>remark:</td>
                                <td><input type="text" name="remark"/></td>
                            </tr>
                            <tr>
                                <td>sex: </td>
                                <td><input type="text" name="sex"/></td>
                            </tr> 
                            <tr>
                                <td colspan="2"> <input type="submit" value="submit"/> </td>
                            </tr>
                         </table>
                    </form>
            </div>            
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/dockpage/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/dockpage/menu.js"></script>
</body>
</html>
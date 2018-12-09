<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
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
    <!-- Datepicker CSS -->
    <%-- <c:url var="fontawesomemincss" value="css/dockpage/font-awesome.min.css" />
    <link href="${fontawesomemincss}" rel="stylesheet" type="text/css" /> --%>

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
<title>Those is not so be good : <sitemesh:write
		property='title' /></title>
<style type='text/css'>
.disclaimer {
	text-align: center;
	border-top: 1px solid #cccccc;
	margin-top: 40px;
	color: #666666;
	font-size: smaller;
}
</style>
    <!-- <sitemesh:write property='head' /> -->
    <!-- <h1>
        Right?
        <sitemesh:write property='title' />
    </h1> -->
</head>
<body>
    <%@ include file="/WEB-INF/views/header.jsp"%>
	<div>
		<sitemesh:write property='body' />
	</div>
	<div class='disclaimer'>Copyright : ok now you are good in some place.</div>
</body>
</html>
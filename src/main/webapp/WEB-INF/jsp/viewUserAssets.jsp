<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>" >
<link rel="stylesheet" href="<c:url value="/css/style.css"/>" >
<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript">
function gotoHomePage(){
	window.open('/assetManagementTool/users/home','_self',false);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Assets</title>
</head>
<body>
<h2>All Assets</h2>
 <!--<c:set var="numOfAssets" value="${fn:length(assets)}"/>   -->
<c:choose>
<c:when test="${numOfAssets == 0}">
No Assets found!!
</c:when>
<c:otherwise>
<div class="container-fluid">
	<table class="table table-striped">
<th>Asset Name</th>
<th>SerialNumber</th>
<th>Description</th>
<th>ModelNumber</th>
<th>brandName</th>
<th>AssignedDate</th>
<c:forEach items="${assets}" var="asset">
<tr id="row${asset.id}">
<td>${asset.name}</td>
<td>
${asset.serialNumber}
</td>
<td>
${asset.description}
</td>
<td>
${asset.modelNumber}
</td>
<td>
${asset.brandName}
</td>
<td>
${asset.assignedDate}
</td>
</tr>
</c:forEach>
</table>
</div>
</c:otherwise>
</c:choose>
<br><p id="info"><font color="red">${sucessmsg}</font></p>
<br>
<input type="button" class="btn btn-success btn-small" value="Back" onclick="javascript:gotoHomePage()">
</body>
</html>
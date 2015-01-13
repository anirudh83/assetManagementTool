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
	window.open('users/home','_self',false);
}

function editAsset(assetId){
	window.open('showEdit/'+assetId,'_self',false);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation Page</title>
</head>
<body>

<div class="container-fluid">
	<table class="table">

<tr><td>Name : ${asset.name}</td></tr>
<tr><td>Description : ${asset.description}</td></tr>
<tr><td>Serial Number : ${asset.serialNumber}</td></tr>
<tr><td>Model Number : ${asset.modelNumber}</td></tr>
<tr><td>Asset type : ${asset.type}</td></tr>
<tr><td>Brand Name : ${asset.brandName}</td></tr>
<tr><td>Assigned date (dd/mm/yyyy):"${asset.assignedDate}</td></tr>
<tr><td>Assign Asset to :
<tr><td>${assignedUser.firstName} ${assignedUser.lastName} ${assignedUser.email} ${assignedUser.employeeId}</td></tr>
</td></tr>
</table>
</div>

<input type="button" class="btn btn-success btn-small" value="ok" onclick="javascript:gotoHomePage()">
<input type="button" class="btn btn-success btn-small" value="edit" onclick="javascript:editAsset(${asset.id})">
</body>
</html>
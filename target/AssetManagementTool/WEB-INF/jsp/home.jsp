<!DOCTYPE HTML>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
</head>
<body>
<script type="text/javascript">
function openViewTasks(){
	window.open('/view','_self',false);
}

function openCreateAssetForm(){
	 window.open('/assetManagementTool/assets/create','_self',false);
}

function logout(){
	window.open('logout','_self',false);
}

function openCreateUserForm(){
    window.open('/assetManagementTool/users/createuser','_self',false);
}

</script>


<div class="container-fluid">
    <form class="bs-docs-example form-inline">
    <fieldset>
<legend>Welcome to Xebia Asset Management Tool, ${user.email}</legend>
<c:if test="${user.isAdmin}">
<h3>ADMIN TASKS</h3>
<input type="button" class="btn btn-primary btn-large" value="all Open Requests" onclick="javascript:openViewRequests()">
<input type="button" class="btn btn-primary btn-large" value="Manage User Rights" onclick="javascript:manageAdminRights()">
<input type="button" class="btn btn-primary btn-large" value="Create New User" onclick="javascript:openCreateUserForm()">
<input type="button" class="btn btn-primary btn-large" value="Create Asset and assign" onclick="javascript:openCreateAssetForm()">
<input type="button" class="btn btn-primary btn-large" value="Change asset ownership" onclick="javascript:allotAssetToUser()">
<h3>&nbsp</h3>
</c:if>
<h3>USER TASKS</h3>
<input type="button" class="btn btn-primary btn-large" value="View all my assets" onclick="javascript:viewAllotedAssets()">
<h3>&nbsp</h3>
<input type="button" class="btn btn-danger btn-large" value="logout" onClick="javascript:logout();">
<br><p><font color="green">${sucessmsg}</font></p>
 </fieldset>
</form>
</div>
</body>
</html>
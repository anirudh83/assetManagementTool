<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/datepicker.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
<script type="text/javascript" src="<c:url value="/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap-datepicker.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Task</title>
</head>
<body>
<script type="text/javascript">
function backPage(){
    	window.open('/assetManagementTool/users/home','_self',false);
}
    
jQuery(function()
{
	jQuery('.datepicker').datepicker();
});
</script>
<form:form method="post" action="/assetManagementTool/assets" commandName="asset">
<div class="container-fluid">
	<table class="table">

<form:hidden path="id"/>

<tr><td>Enter name :<form:input path="name" required="true"/>
<form:errors class="text-error" path="name" /></td></tr>
<tr><td>Description :<form:input path="description" required="true"/>
<form:errors class="text-error" path="description"/></td></tr>
<tr><td>Enter serial Number :<form:input path="serialNumber" required="true"/>
<form:errors class="text-error" path="serialNumber" /></td></tr>
<tr><td>Enter model Number :<form:input path="modelNumber" required="true"/>
<form:errors class="text-error" path="modelNumber" /></td></tr>
<tr><td>Enter asset type :<form:input path="type" required="true"/>
<form:errors class="text-error" path="type" /></td></tr>
<tr><td>Enter asset type :<form:input path="brandName" required="true"/>
<form:errors class="text-error" path="brandName" /></td></tr>
<tr><td>Enter Assigned date (dd/mm/yyyy):
<form:input path="assignedDate" class="datepicker" data-date-format="dd/mm/yyyy" readonly="true" type="text" required="true"/>
<form:errors class="text-error" path="assignedDate" /></td></tr>
<tr><td>Assign Asset to :<select name="userId">
<option value="0">Self</option>
<c:forEach items="${users}" var="user">
<option value="${user.id}">${user.firstName}</option>
</c:forEach>
</select></tr>
<tr><td><input type="submit" class="btn btn-success btn-small" value="Submit">
<input type="button" class="btn btn-success btn-small" value="Back" onclick="javascript:backPage()"></td></tr>
</table>
</div>
</form:form>
</body>
</html>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Update Accessory</title>

<style>
.button {
	width: 30%;
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

input[type=button] {
	width: 33.2%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit],a {
	width: 33.2%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

input[type=button]:hover {
	background-color: #45a049;
}

input[type=text],select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.error {
	color: red;
}
</style>
</head>

<body>
	<form:form method="post" commandName="updateAccessory">

		<table>
			<tr>
				<td align="right" width="20%"><form:label path="accessoryName">Accessory Name</form:label>
				<td><form:input path="accessoryName" /></td>
				<td width="60%"><form:errors path="accessoryName" cssClass="error" /></td>
	<td><br />
			</tr>
			<tr>
				<td align="right" width="20%"><form:label path="accessoryDescription">accessory Description</form:label>
				<td><form:input path="accessoryDescription" /></td>
				<td width="60%"><form:errors path="accessoryDescription" cssClass="error" /></td>

			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Update">
	</form:form>
	<br />
	<td><input type="button" value="Home"
		onclick="window.location.href='http://localhost:8080/springapp/accessorys.htm'" /></td>
</body>

</html>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Add Product</title>

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

	<h1>
		<fmt:message key="addproduct.heading" />
	</h1>
	<form:form method="post" commandName="product">
		<table>
			<tr>
				<td align="right" width="20%">Name:</td>
				<td width="20%"><form:input path="name" /></td>
				<td width="60%"><form:errors path="name" cssClass="error" /></td>

			</tr>
			<tr>
				<td align="right" width="20%">Description:</td>
				<td width="20%"><form:input path="description" /></td>
				<td width="60%"><form:errors path="description"
						cssClass="error" /></td>


			</tr>
			<tr>
				<td align="right" width="20%">Color:</td>
				<td><form:select path="color.colorID">
						<form:options items="${modelList}" itemLabel="colorName"
							itemValue="colorID" />
					</form:select></td>
			</tr>
			<tr>
				<td align="right" width="20%">Weight:</td>
				<td width="20%"><form:input path="weight" /></td>
				<td width="60%"><form:errors path="weight" cssClass="error" /></td>

			</tr>
			<tr>
				<td align="right" width="20%">Price:</td>
				<td width="20%"><form:input path="price" /></td>
				<td width="60%"><form:errors path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td align="right" width="20%">Stock:</td>
				<td width="20%"><form:input path="stock" /></td>
				<td width="60%"><form:errors path="stock" cssClass="error" /></td>
			</tr>
			<tr>
				<td align="right" width="20%">Accessory:</td>
				<td><form:radiobuttons items="${modelAccess}"
						path="accessory.accessoryID" itemLabel="accessoryName"
						itemValue="accessoryID" /></td>

			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Add">
	</form:form>
	<br />
	<input type="button" value="Home"
		onclick="window.location.href='http://localhost:8080/springapp/hello.htm'" />
</body>

</body>

</html>
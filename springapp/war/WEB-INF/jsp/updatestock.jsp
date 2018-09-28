<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Update Stock</title>


<style>

input[type=submit] {
    width: 20%;
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

input[type=text],select {
    font-size: 14px;
	font-family: "Times New Roman", Times, serif;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

html {
	position: relative;
	min-height: 100%;
	overflow-x: hidden;
}

body {
	margin-bottom: 60px;
	overflow-x: hidden;
}
</style>
</head>

<body>

	<form:form method="post" commandName="updateStock">
			Select a Name:&nbsp;
		<td><form:select path="productId">
				<form:option value="NONE" label="--- Select ---" />
				<form:options items="${modelList}" itemLabel="name" itemValue="id" />
			</form:select></td>
		<br />
		<br />
		<td align="right" width="20%">Stock:</td>
		<td width="20%">
		<td><form:input path="newStock"/></td><br/>
		<input type="submit" value="Submit" />

	</form:form>

</body>

</html>
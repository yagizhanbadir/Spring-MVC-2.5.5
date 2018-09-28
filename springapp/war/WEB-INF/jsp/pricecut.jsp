<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<style>

input[type=submit] {
    width: 28.2%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=button] {
    width: 28.2%;
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

input[type=text]{
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
		<fmt:message key="pricecut.heading" />
	</h1>
	<form:form method="post" commandName="priceCut">
		<table >
			<tr>
				<td align="right" width="20%">Cut (%):</td>
				<td width="20%"><form:input path="percentage" /></td>
				<td width="60%"><form:errors path="percentage" cssClass="error" />
				</td>
			</tr>
		</table>
		
		
		<br>
		<input type="submit" align="center" value="Execute">
	</form:form>
<input type="button" value="Home"
		onclick="window.location.href='http://localhost:8080/springapp/hello.htm'" /></body>
</html>
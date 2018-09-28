<%@ include file="/WEB-INF/jsp/include.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>
<title><fmt:message key="title" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>


html {
	position: relative;
	min-height: 100%;
	overflow-x: hidden;
}

body {
	margin-bottom: 60px;
	overflow-x: hidden;
}

.ButtonCheck {
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
    background-color: B86613;
}

input[type=button]:hover {
    background-color: #000000;
}

table {
	font-family: arial, sans-serif;
	border-collapse: separate;
	width: 100%;
}

th {
	background-color: #000000;
	border: 1px solid black;
	text-align: left;
	padding: 8px;
	color: white;
}

td {
	border: 1px solid black;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #96B0DC;
}

.buttonBorder {
	border: none;
	padding: 10px;
	border-radius: 50%;
	background-color: #D4DDDD;
}

.buttonDelete,a {
	border: none;
	padding: 10px;
	border-radius: 20px;
	background-color:  #ffad33
	
}
</style>
</head>
<body>
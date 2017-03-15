<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LISTA TRENEROW</h1>
<table>
	<#list iCoachService as item>
		<tr>
			<td><a href="http://localhost:8090/coach/onecoach/${item.id}">${item.firstName}</a></td>
			<td>${item.lastName}  / </td>
			<td>${item.city}</td>
		</tr>
	</#list>
</table>
</body>
</html>


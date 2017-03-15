<#import "/spring.ftl" as spring>
<@spring.bind "deleteAccount"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/coach/logcoach/deleteAcc/" method="POST" class="formulaz">
	<h1>Delete account ?</h1>
	
	<input type="submit" value="YES" class="button"/>
</form>

</body>
</html>
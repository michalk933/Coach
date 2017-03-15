<#import "/spring.ftl" as spring>
<@spring.bind "coachPass"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/coach/logcoach/" method="POST" class="formulaz">
	<p class="label">login</p>
	<@spring.formInput "coachPass.login"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Password</p>
	<@spring.formPasswordInput "coachPass.password"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<input type="submit" value="CHECK" class="button"/>
</form>

</body>
</html>
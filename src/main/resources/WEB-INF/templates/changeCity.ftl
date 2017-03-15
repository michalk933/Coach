<#import "/spring.ftl" as spring>
<@spring.bind "changeCity"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/coach/logcoach/newcity/" method="POST" class="formulaz">
	<h1>New city</h1>
	<@spring.formInput "changeCity.city"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<input type="submit" value="SEND" class="button"/>
</form>





</body>
</html>
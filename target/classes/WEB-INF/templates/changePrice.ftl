<#import "/spring.ftl" as spring>
<@spring.bind "changePrice"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/coach/logcoach/newPrice/" method="POST" class="formulaz">
	<h1>New price</h1>
	<@spring.formInput "changePrice.price"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<input type="submit" value="CHANGE" class="button"/>
</form>

</body>
</html>
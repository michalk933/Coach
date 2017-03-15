<#import "/spring.ftl" as spring>
<@spring.bind "pricecoach"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/coach/price/" method="POST">
		<@spring.formInput "pricecoach.price"/></br>
		
		<input type="submit" value="lOOKING" />

	</form>
</body>
</html>
<#import "/spring.ftl" as spring>
<@spring.bind "citycoach"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>You are looking coach from what city ?</h3>

<form action="/coach/coachcity/" method="POST" class="formulaz">
	<@spring.formInput "citycoach.city"/></br>
	<@spring.showErrors "</br>" /> </br>
	<p>Warszawa</p>
	<p>Krakow</p>
	<p>Wroclaw</p>
	<p>Krakow</p>
	<p>Katowice</p>
	<p>Chrzanow</p>
	<input type="submit" value="SEND" class="button"/>
</form>




</body>
</html>
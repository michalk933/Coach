<#import "/spring.ftl" as spring>
<@spring.bind "regPerson"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/coach/regper/" method="POST" class="formulaz">
	<h1>New account</h1>
	<p class="label">Login</p>
	<@spring.formInput "regPerson.login"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Password</p>
	<@spring.formInput "regPerson.password"/></br>
	<@spring.showErrors "</br>" /> </br>
	

	<p class="label">Firstname</p>
	<@spring.formInput "regPerson.firstName"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Lastname</p>
	<@spring.formInput "regPerson.lastName"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Cuntry</p>
	<@spring.formInput "regPerson.cuntry"/></br>
	<@spring.showErrors "</br>" /> </br>

	<p class="label">City</p>
	<@spring.formInput "regPerson.city"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">ZipCode</p>
	<@spring.formInput "regPerson.zipCode"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Mob number</p>
	<@spring.formInput "regPerson.mob"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Price</p>
	<@spring.formInput "regPerson.price"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	
<input type="submit" value="SEND" class="button"/>

</body>
</html>
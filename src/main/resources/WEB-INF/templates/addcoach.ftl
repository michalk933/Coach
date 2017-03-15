<#import "/spring.ftl" as spring>
<@spring.bind "fromCoach"/>
<!DOCTYPE html>
<html>
<head>

<style>
.formulaz {
    font-family: Arial, Helvetica, sans-serif; 
    text-align: center;
    padding-top: 30px;
}

.label{
	padding-bottom: -5px;
	color: #f29c40;
	font-family: Arial, Helvetica, sans-serif;
}
input{
	background-color: #e6f4ff;
}

.button{
	color: blue;
	size: 30px;
}

.contener{
	height: 760px;
	width: 300px;
	background-color: #b3ddff;
	margin: auto;
}

</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="contener">

<form action="/coach/save/" method="POST" class="formulaz">
	<h1>Add Coach</h1>
	<p class="label">Firstname</p>
	<@spring.formInput "fromCoach.firstName"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Lastname</p>
	<@spring.formInput "fromCoach.lastName"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Cuntry</p>
	<@spring.formInput "fromCoach.cuntry"/></br>
	<@spring.showErrors "</br>" /> </br>

	<p class="label">City</p>
	<@spring.formInput "fromCoach.city"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">ZipCode</p>
	<@spring.formInput "fromCoach.zipCode"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Mob number</p>
	<@spring.formInput "fromCoach.mob"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Price</p>
	<@spring.formInput "fromCoach.price"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	
<input type="submit" value="SEND" class="button"/>
</form>
</div>
</body>
</html>
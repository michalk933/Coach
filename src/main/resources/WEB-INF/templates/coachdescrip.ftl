<#import "/spring.ftl" as spring>
<@spring.bind "newComment"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<#list coachList as item>
		<tr>
			<td><h1>PERSONAL TRAINER</h1></td>
		</tr>
		<tr>
			<td><b>Firstname and lastname :</b> <i>${item.firstName}  ${item.lastName}</i></td>
		</tr>
		<tr>
			<td><b>Place :</b> <i>${item.cuntry},  ${item.city},  ${item.zipCode}</i></i></td>
		</tr>
		<tr>
			<td><b>Mob :</b> <i>${item.mob}</i>  / Price : <i>${item.price}</i> $$</td>
		</tr>
	</#list>
</table>
	
	
<h3>Comment</h3>
<table>
<#list CommentList as itemCom>
	
		<tr>
			<td><b>Author : </b> <i>${itemCom.author}</i></td>
		</tr>
		<tr>
			<td><b>Comment : </b> <i>${itemCom.descrip}</i></i></td>
		</tr>
		
	</#list>
</table>
	

<h4>Add comment</h4>
<form action="/coach/onecoach/addNewCom/" method="POST" class="formulaz">
	<h1>Add Coach</h1>
	<p class="label">Author</p>
	<@spring.formInput "newComment.author"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<p class="label">Comment</p>
	<@spring.formInput "newComment.descrip"/></br>
	<@spring.showErrors "</br>" /> </br>
	
	<input type="submit" value="ADD" class="button"/>
</form>
	

</body>
</html>
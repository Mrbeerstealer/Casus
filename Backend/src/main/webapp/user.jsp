<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Hello</title>
	</head>
	<body>
		<table>
			<thead>
				<tr style="background-color: black; color: white">				
					<td width="80px">name</td>
					<td width="80px">lastName</td>
					<td width="80px">location</td>
					<td width="80px"></td>
				</tr>	
			</thead>
			<tr style="background-color: white; color: black">
				<td width="80px">${user.name} </td>
				<td width="80px">${user.lastName} </td>
				<td width="80px">${user.xCoordinate}</td>
				<td width="80px">${user.yCoordinate} </td>
			</tr>	
		</table>
		<table>
			<thead>
				<tr style="background-color: black; color: white">				
					<td width="80px">name</td>
					<td width="80px">description</td>
					<td width="80px">does attend</td>
				</tr>	
			</thead>
			
			<c:forEach items="${userEvents}" var="userEvent">
				<tr style="background-color: white; color: black">
					<td width="80px"><c:out value="${userEvent.event.name}"/> </td>
					<td width="80px"><c:out value="${userEvent.event.description}"/> </td>
					<td width="80px"><c:out value="${userEvent.doesAttend}"/> </td>
				</tr>
			</c:forEach>
		</table>
		
		<form method="post" action="/user/${user.id}/add/event">
			<button type="submit">Add events</button>
		</form>
		<form method="post" action="/user/s/find">
			<button type="submit">
				Users
			</button>
		</form>
	</body>
</html>
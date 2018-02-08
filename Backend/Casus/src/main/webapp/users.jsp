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
					<td width="80px"></td>
				</tr>	
			</thead>
			
			<c:forEach items="${users}" var="user">
				<tr style="background-color: white; color: black">
					<td width="80px"><c:out value="${user.name}"/> </td>
					<td width="80px"><c:out value="${user.lastName}"/> </td>
					<td width="80px"><c:out value="${user.xCoordinate}"/> </td>
					<td width="80px"><c:out value="${user.yCoordinate}"/> </td>
					<td width="80px"><form method="post" action="/user/${user.id}/find">
										<button type="submit">Go to</button>
									 </form></td>
				</tr>
			</c:forEach>
			
		</table>
		
		<form method="post" action="/user/new">
			<p>Name:</p>
			<input type="text" name=name />
			<p>Last Name:</p>
			<input type="text" name=lastName />
			<p>Location(x,y):</p>
			<input type="text" name=xCoordinate /><input type="text" name=yCoordinate /><br />
			<button type="submit">
				Versturen
			</button>
		</form>
		<form method="post" action="/event/s/find">
			<button type="submit">
				Events
			</button>
		</form>
	</body>
</html>
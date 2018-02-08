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
					<td width="80px">description</td>
					<td width="80px"></td>
				</tr>	
			</thead>
			
			<c:forEach items="${events}" var="event">
				<tr style="background-color: white; color: black">
					<td width="80px"><c:out value="${event.name}"/> </td>
					<td width="80px"><c:out value="${event.description}"/> </td>
					<td width="80px"><form method="post" action="/userEvent/new/${userId}_${event.identifier}">
										<button type="submit">Add to list</button>
									 </form></td>
				</tr>
			</c:forEach>
			
		</table>
		<form method="post" action="/user/${userId}/find">
			<button type="submit">
				Return
			</button>
		</form>
	</body>
</html>
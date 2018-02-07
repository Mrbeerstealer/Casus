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
					<td width="80px">date</td>
					<td width="80px">event type</td>
					<td width="80px">location</td>
					<td width="80px"></td>
				</tr>	
			</thead>
			<tr style="background-color: white; color: black">
				<td width="80px">${event.name} </td>
				<td width="80px">${event.description} </td>
				<td width="80px">${event.date} </td>
				<td width="80px">${event.eventType} </td>
				<td width="80px">${event.xCoordinate} </td>
				<td width="80px">${event.yCoordinate} </td>
			</tr>
		</table>
		<table>
			<thead>
				<tr style="background-color: black; color: white">				
					<td width="80px">name</td>
					<td width="80px">lastName</td>
					<td width="80px">does attend</td>
				</tr>	
			</thead>
			
			<c:forEach items="${userEvents}" var="userEvent">
				<tr style="background-color: white; color: black">
					<td width="80px"><c:out value="${userEvent.user.name}"/> </td>
					<td width="80px"><c:out value="${userEvent.user.lastName}"/> </td>
					<td width="80px">
						<select name = "doesAttend">
							<c:forEach items="${doesAttends}" var="doesAttendee">
								<c:choose>
									<c:when test="${userEvent.doesAttend == doesAttendee}">
										<option selected = "selected">${doesAttendee}</option>
									</c:when> <c:otherwise>
										<option>${doesAttendee}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<td width="80px"><c:out value="${userEvent.doesAttend}"/> </td>
				</tr>
			</c:forEach>
		</table>
		
		<form method="post" action="/event/${event.identifier}/add/user">
			<button type="submit">Add users</button>
		</form>
		<form method="post" action="/event/s/find">
			<button type="submit">Return to events</button>
		</form>
		
	</body>
</html>
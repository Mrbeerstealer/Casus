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
			
			<c:forEach items="${events}" var="event">
				<tr style="background-color: white; color: black">
					<td width="80px"><c:out value="${event.name}"/> </td>
					<td width="80px"><c:out value="${event.description}"/> </td>
					<td width="80px"><c:out value="${event.date}"/> </td>
					<td width="80px"><c:out value="${event.eventType}"/> </td>
					<td width="80px"><c:out value="${event.xCoordinate}"/> </td>
					<td width="80px"><c:out value="${event.yCoordinate}"/> </td>
					<td><form method="post" action="/event/${event.identifier }/find">
							<button type="submit">Go to</button>
						</form></td>
				</tr>
			</c:forEach>
			
		</table>
		
		<form method="post" action="/event/new">
			<p>Name:</p>
			<input type="text" name=name />
			<p>Description:</p>
			<input type="text" name=description />
			<p>Date:</p>
			<input type="text" name=date />
			<p>Event type:</p>
			<select name = "eventType">
				<c:forEach items="${eventTypes}" var="eventType">
					<option>${eventType}</option>
				</c:forEach>
			</select>
			<p>Is this event private?:</p>
			<input type="radio" name=isPrivate value="false" checked/> No
			<input type="radio" name=isPrivate value="true"/> Yes
			<p>Location(x,y):</p>
			<input type="text" name=xCoordinate /><input type="text" name=yCoordinate /><br />
			<button type="submit">
				Versturen
			</button>
		</form>
		<form method="post" action="/user/s/find">
			<button type="submit">
				Users
			</button>
		</form>
		
	</body>
</html>
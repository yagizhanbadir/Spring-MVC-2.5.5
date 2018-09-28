<%@ include file="/WEB-INF/jsp/hellostyle.jsp"%>



<table>
	<caption>
		<h2>COLORS</h2>
	</caption>
	<thead>
		<th width="15%">NAME</th>
		<th width="15%">CODE</th>
		<th width="15%">Action</th>

	</thead>
	<tbody>
		<c:forEach items="${model.accessorys}" var="accessory">
			<tr>
				<td><c:out value="${accessory.accessoryName}" /></td>
				<td><c:out value="${accessory.accessoryDescription}" /></td>
				<td>
					<table>
						<form action="/springapp/deleteaccessory.htm" method="post"
							commandName="deleteAccessory" />
						<input type="hidden" name="accessoryID" value="${accessory.accessoryID}" />
						<input type="submit" value="Delete" class="button buttonDelete" />
						</form>
						&nbsp;&nbsp;

						<input type="button" value="Update" class="ButtonCheck" 
							onclick="window.location.href='http://localhost:8080/springapp/updateaccessory.htm?accessoryID=${accessory.accessoryID}'" />
						<br /> &nbsp;&nbsp;
					</table>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<br/>
	<div>
	<td><input type="button" value="Add accessory" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/addaccessory.htm'" /></td><br/>
	<td><input type="button" value="Home" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/hello.htm'" /></td>
		</div>
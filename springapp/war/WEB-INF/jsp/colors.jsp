
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
		<c:forEach items="${model.colors}" var="color">
			<tr>
				<td><c:out value="${color.colorName}" /></td>
				<td><c:out value="${color.colorCode}" /></td>
				<td>
					<table>
						<form action="/springapp/deletecolor.htm" method="post"
							commandName="deleteColor" />
						<input type="hidden" name="colorID" value="${color.colorID}" />
						<input type="submit" value="Delete" class="button buttonDelete" />
						</form>
						&nbsp;&nbsp;

						<input type="button" value="Update" class="ButtonCheck" 
							onclick="window.location.href='http://localhost:8080/springapp/updatecolor.htm?colorID=${color.colorID}'" />
						<br /> &nbsp;&nbsp;
					</table>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<br/>
	<div>
	<td><input type="button" value="Add color" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/addcolor.htm'" /></td><br/>
	<td><input type="button" value="Home" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/hello.htm'" /></td>
		</div>
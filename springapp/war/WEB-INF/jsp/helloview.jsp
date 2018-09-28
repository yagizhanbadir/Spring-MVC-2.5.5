<h1>
	<fmt:message key="heading" />
</h1>
<p>
	<fmt:message key="greeting" />
	<c:out value="${model.now}" />
</p>

<table>
	<caption>
		<h2>Products</h2>
	</caption>
	<thead>
		<th width="11%">Name</th>
		<th width="11%">Description</th>
		<th width="11%">Color</th>
		<th width="11%">Weight</th>
		<th width="11%">Price</th>
		<th width="11%">Stock</th>
		<th width="11%">Accessorys</th>
		<th width="15%">Action</th>
		<th width="11%">Stock Info</th>

	</thead>
	<tbody>
		<c:forEach items="${model.products}" var="prod">
			<tr>
				<td><c:out value="${prod.name}" /></td>
				<td><c:out value="${prod.description}" /></td>
				<td><c:out value="${prod.color.colorName}" /></td>
				<td><c:out value="${prod.weight}" /></td>
				<td><i>$<c:out value="${prod.price}" /></i></td>
				<td><c:out value=" ${prod.stock }" /></td>
				<td><c:out value=" ${prod.accessory.accessoryName}" /></td>

				<td>

					<table>
						<form action="/springapp/delete.htm" method="post"
							commandName="deleteProduct" />
						<input type="hidden" name="id" value="${prod.id}" />
						<input type="submit" value="Delete" class="button buttonDelete" />
						</form>
						&nbsp;&nbsp;

						<input type="button" value="Update" class="btn btn-danger"
							onclick="window.location.href='http://localhost:8080/springapp/updateproduct.htm?id=${prod.id}'" />
						<br /> &nbsp;&nbsp;
					</table>
				</td>
				<td>
					<table>
						<form action="/springapp/decreasestock.htm" method="post"
							commandName="decreaseStock" />
						<input type="hidden" name="id" value="${prod.id}" />
						<input type="submit" value="-" class="button buttonBorder" />
						</form>
						&nbsp;&nbsp;
						<c:out value="1" />
						&nbsp;&nbsp;

						<form action="/springapp/increasestock.htm" method="post"
							commandName="increaseStock" />
						<input type="hidden" name="id" value="${prod.id}" />
						<input type="submit" value="+" class="button buttonBorder" />
						</form>
					</table>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<div>

	<input type="button" value="Increase Prices" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/priceincrease.htm'" /><br />

	<input type="button" value="Cut Prices" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/pricecut.htm'" /><br />

	<input type="button" value="Add Product" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/addproduct.htm'" /><br />

	<input type="button" value="Update Stock" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/updatestock.htm'" /><br />

	<input type="button" value="Colors" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/colors.htm'" /><br />

	<input type="button" value="Accessorys" class="ButtonCheck"
		onclick="window.location.href='http://localhost:8080/springapp/accessorys.htm'" /><br />



</div>
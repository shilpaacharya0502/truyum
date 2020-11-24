<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- <link rel="stylesheet" href="styles/style.css"> -->
<style>
	<%@ include file="../styles/style.css"%>
</style>
<script src="scripts/code.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body onload="menuListAdminLoaded()">
	<header>
		<div id="header-container">
			<div class="col-3">
				truYum <img src="images/truYumlogo.png" height="30" width="30">
			</div>
			<div class="col-2">
				<a href="menu-item-list-admin.jsp" class="menubutton">Menu</a>
			</div>
		</div>
	</header>
	<div class="body">
		<h1 class="body-text-heading" id="">Menu Items</h1>
		<div id="menu-Item-List-Result">
			<table>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Active</th>
					<th>Date of launch</th>
					<th>Category</th>
					<th>Free Delivery</th>
					<th></th>
				</tr>
				<c:forEach var="item" items="${menuItemListAdmin}">
					<tr>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.active}</td>
						<td>${item.dateOfLaunch}</td>
						<td>${item.category}</td>
						<td>${item.freeDelivery}</td>
						<td><a href="/show-edit-menu-item?menuItemId=${item.id}">Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<footer>Copyright @ 2019</footer>
</body>
</html>
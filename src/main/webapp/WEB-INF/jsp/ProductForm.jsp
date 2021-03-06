<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="global">
		<c:if test="${requestScope.errors != null}">
			<p>
				Error(s)!
				<ul>
					<c:forEach var="error" items="${requestScope.errors}">
						<li>${error}</li>
					</c:forEach>
				</ul>
			</p>
		</c:if>
		<form action="product_save.action" method="post">
			<fieldset>
				<legend>Add a product</legend>
				<p>
					<label for="name">Product Name: </label>
					<input type="text" id="name" name="name" tabindex="1"/>
				</p>
				<p>
					<label for="description"> Description: </label>
					<input type="text" id="description" name="description" tabindex="2"/>
				</p>
				<p>
					<label for="price">Price: </label>
					<input type="text" id="price" name="price" tabindex="3"/>
				</p>
				<p id="button">
					<input id="reset" type="reset" tabindex="4"/>
					<input id="submit" type="submit" tabindex="5" value="Add Product"/>
				</p>
			</fieldset>
		</form>
	</div>

</body>
</html>
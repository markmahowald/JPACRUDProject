<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip Logger</title>

<jsp:include page="bootstrapHead.jsp" />

<style type="text/css"></style>
</head>
<body>
	<div class="container-fluid">
		<form action="search.do" method="GET">
			Trip ID: <input type="text" name="tripId" /> <input type="submit"
				class="btn btn-primary" value="Inspect Trip" />
		</form>
		<br/>
			<c:if test="${not empty tripList }">
				<ol>
					<c:forEach var="Trip" items="${tripList}">
						<li><a href="search.do?tripId=${trip.id }">${trip.id },
								${trip.date}</a>, ${trip.milesDriven } miles.</li>
					</c:forEach>
				</ol>
			</c:if>
		
	</div>


	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>

<!-- <a href="getFilm.do?fid=1">ACADEMY DINOSAUR</a> -->
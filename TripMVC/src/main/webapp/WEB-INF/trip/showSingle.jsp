<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Boot Car Trip Show Single Ride</title>
<jsp:include page="../bootstrapHead.jsp" />
</head>
<body>
	<div container="container-fluid">
		<div>
			<h5>${trip.date}:drove ${trip.milesDriven} miles with ${trip.passengers} passenger(s).</h5>
			<p>${trip.description}</p>
		</div>
	</div>
	<jsp:include page="../bootstrapFoot.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3 class="pb-3 pt-3">Report Applications</h3>
		<form:form action="search" modelAttribute="search" method="POST">

			<table>
				<tr>
					<td>Plan Name: <form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${plans}" />
						</form:select>
					</td>
					<td>Plan Staus: <form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}" />
						</form:select>
					</td>
					<td>Gender: <form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="FeMale">FeMale</form:option>
						</form:select>
					</td>

				</tr>
				<tr>
					<td>StartDate: <form:input path="startDate" type="date" /></td>
					<td>EndDate:<form:input path="endDate" type="date" />
					</td>
				</tr>
				<tr>
				
					<td><a href="/" class="btn btn-secondary">Reset</a>
					<input type="submit" value="Search"
						class="btn btn-primary" /></td>
				</tr>
			</table>

		</form:form>
		<hr />
		
		<table class="table table-striped table-hover">
			<tr>
				<th>S.No</th>
				<th>Holder Name</th>
				<th>Gender</th>
				<th>Plan Name</th>
				<th>Plan Status</th>
				<th>Plan Start Date</th>
				<th>Plan End Date</th>
				<th>Benfial Amount</th>
			</tr>
				
			<tbody   class="table table-hover">
				<c:forEach items="${plan}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benifiAmount}</td>
						
					</tr>
				</c:forEach>
				<tr>
				<c:if test="${empty plan}">
				<td colspan="8" style="text-align: center">No Records Found</td>
				</c:if>
				</tr>
			</tbody>
			
		</table>
	
		<hr />

		Export: <a href="excel">Excel</a> <a href="pdf">Pdf</a>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
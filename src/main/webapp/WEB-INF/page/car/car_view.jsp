<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="<c:url value="/"/>"><spring:message
								code="To the list of manufacturers" /></a></li>
					<li class="breadcrumb-item" aria-current="page"><a
						href="<c:url value="/${brand }"/>"><c:out value="${brand}" /></a></li>
					<li class="breadcrumb-item active" aria-current="page"><c:out
							value="${model}" /></li>
				</ol>
			</nav>
		</div>

		<div class="col-md-6">
			<h4>
				<c:out value="${car.year}" />
				<c:out value="${brand}" />
				<c:out value="${model}" />
			</h4>
		</div>

		<div class="col-md-6">
			<h4 align="right">
				<spring:message code="car.Price from" />
				<c:out value="${car.price }" />
				$
			</h4>
		</div>

		<div class="col-md-12">
			<div id="carouselExampleFade" class="carousel slide carousel-fade"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100"
							src='<c:url value="/image/${car.image}" />' alt="First slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleFade"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleFade"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>

		<div class="col-12">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><spring:message code="car.Body type" /></th>
						<th><spring:message code="car.Length, mm" /></th>
						<th><spring:message code="car.Width, mm" /></th>
						<th><spring:message code="car.Height, mm" /></th>
						<th><spring:message code="car.Base, mm" /></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${car.bodyType }</td>
						<td>${car.length }</td>
						<td>${car.width }</td>
						<td>${car.height }</td>
						<td>${car.base }</td>
					</tr>
				</tbody>
				<thead>
					<tr>
						<th><spring:message code="car.Number of doors" /></th>
						<th><spring:message code="car.Clearance, mm" /></th>
						<th><spring:message code="car.Luggage compartment, l" /></th>
						<th><spring:message code="car.Tank capacity, l" /></th>
						<th><spring:message code="car.Number of places" /></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${car.numberOfDoors }</td>
						<td>${car.clearance }</td>
						<td>${car.trunk }</td>
						<td>${car.volumeOfTheTank }</td>
						<td>${car.numberOfPlaces }</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</div>
<%@ include file="../include/end-html.jsp"%>
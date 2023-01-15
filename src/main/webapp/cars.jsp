<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cars</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="background" style="background-color: #ecf2ea; max-width: 3000px; margin:auto">
    <div class="container">
        <div class="row">

            <nav class="navbar" style="background-color: #ccccff;">
                <div class="container-fluid">
                    <a class="navbar-brand">Cars</a>
                    <form action="/cars" method="get" class="d-flex" role="search">
                        <a class="navbar-brand">Enter the car ID</a>
                        <input name="id" class="form-control me-2" type="search" placeholder="Search"
                               aria-label="Search">
                        <button class="btn" style="background-color: #8e7cc3;" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <p>
            <h5>Click on the Search button to see all cars</h5>
            <p>

            <table class="table" class="row g-3" style="background-color: #ccccff;">
                <thead>
                <tr><th scope="col">ID</th>
                    <th scope="col">Model</th>
                    <th scope="col">Number</th>
                    <th scope="col">Owner</th>
                    <th scope="col">Delete</th></tr>
                </thead>

                <tbody>
                <c:if test="${carById !=null}">
                    <tr>
                        <th scope='row'>${carById.id}<td>${carById.model}</td><td>${carById.number}</td><td>${carById.owner}</td><td>
                            <form action="/delete" method="post"><input name="id-for-delete" type="hidden" value="${carById.id}">
                                <button class="btn" style="background-color: #8e7cc3;" type="submit">Delete car</button>
                            </form></td>
                        <td><form action="/update" method="post" class="row g-3">
                                <div class="col-2">
                                    <input name="car-model" type="text" class="form-control" placeholder="Model">
                                </div>
                                <div class="col-2">
                                    <input name="car-number" type="text" class="form-control" placeholder="Number">
                                </div>
                                <div class="col-2">
                                    <input name="car-owner" type="text" class="form-control" placeholder="Owner">
                                </div>
                                <div class="col-2">
                                    <input name="id-for-update" type="hidden" value="${carById.id}">
                                    <button class="btn" style="background-color: #8e7cc3;" type="submit">Update car
                                    </button>
                                </div>
                            </form></td></th></tr>
                </c:if>

                <c:if test="${id == null || id.isBlank()}">
                    <c:forEach items="${cars}" var="car">
                        <tr>
                            <th scope='row'>${car.id}<td>${car.model}</td><td>${car.number}</td><td>${car.owner}</td><td>
                                <form action="/delete" method="post"><input name="id-for-delete" type="hidden" value="${car.id}">
                                    <button class="btn" style="background-color: #8e7cc3;" type="submit">Delete car</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>

            <p>
            <form action="/addCar" method="post" class="row g-3 needs-validation" novalidate>
                <h5>Fill in the fields to create a record about your car</h5>
                <div class="col-md-2">
                    <label class="form-label">ID</label>
                    <input name="car-id" type="text" class="form-control">
                </div>
                <div class="col-md-2">
                    <label class="form-label">Model</label>
                    <input name="car-model" type="text" class="form-control">
                </div>
                <div class="col-md-2">
                    <label class="form-label">Number</label>
                    <input name="car-number" type="text" class="form-control">
                </div>
                <div class="col-md-2">
                    <label class="form-label">Owner</label>
                    <input name="car-owner" type="text" class="form-control">
                </div>
                <div class="col-12">
                    <button class="btn" style="background-color: #8e7cc3;" type="submit">Create car</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
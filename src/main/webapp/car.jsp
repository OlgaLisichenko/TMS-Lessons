<%@ page import="static org.example.DeleteCarServlet.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="org.example.Car" %>
<%@ page import="org.example.CarStorage" %>
<%@ page import="static org.example.GetCarServlet.*" %>
<%@ page import="static org.example.AddCarServlet.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <table class="table" style="background-color: #ccccff;">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Model</th>
                    <th scope="col">Number</th>
                    <th scope="col">Owner</th>
                </tr>
                </thead>
                <tbody>
                <%
                    HashMap<String, Car> cars = CarStorage.getCars();
                    if (carById != null) {
                        out.println("<th scope='row'>" + id + " " +
                                    ("<td>" + carById.getModel() + "</td><td>" + carById.getNumber() + "</td><td>" + carById.getOwner() + "</td>"));
                    } else if (id == null || id.isBlank()) {
                        Set<String> keys = cars.keySet();
                        for (String key : keys) {
                            Car car = cars.get(key);
                            out.println("<tr><th scope='row'>" + key + " " +
                                        ("<td>" + car.getModel() + "</td><td>" + car.getNumber() + "</td><td>" + car.getOwner() + "</td>") + "</th>");
                        }
                    } else if (id != null && !id.isBlank()) {
                        out.println("<p class=\"fst-normal\" style=\"color: #d74646;\">A car with this ID was not found</p>");
                    }
                %>
                </tbody>
            </table>

            <p>
            <form action="/addCar" method="post" class="row g-3 needs-validation" novalidate>
                <h5>Fill in the fields to create a record about your car</h5>
                <div class="col-md-2">
                    <label for="validationCustom01" class="form-label">ID</label>
                    <input name="car-id" type="text" class="form-control" id="validationCustom01">
                </div>
                <div class="col-md-2">
                    <label for="validationCustom02" class="form-label">Model</label>
                    <input name="car-model" type="text" class="form-control" id="validationCustom02">
                </div>
                <div class="col-md-2">
                    <label for="validationCustom03" class="form-label">Number</label>
                    <input name="car-number" type="text" class="form-control" id="validationCustom03" required>
                </div>
                <div class="col-md-2">
                    <label for="validationCustom05" class="form-label">Owner</label>
                    <input name="car-owner" type="text" class="form-control" id="validationCustom05" required>
                </div>
                <div class="col-12">
                    <button class="btn" style="background-color: #8e7cc3;" type="submit">Create car</button>
                </div>
            </form>
            <%
                if (addCar != null) {
                    out.println("<p class=\"fst-normal\" style=\"color: #d74646;\">Car with this id already exists</p>");
                } else if (addId != null && !addId.isBlank()){
                    out.println("The record of the car was successfully created");
                }
            %>

            <p>
            <form action="/delete" method="post" class="row g-3">
                <h5>Enter the ID of the car you want to delete</h5>
                <div class="col-md-2">
                    <label for="inputPassword2" class="visually-hidden">Password</label>
                    <input name="id-for-delete" type="text" class="form-control" id="inputPassword2"
                           placeholder="Car ID">
                </div>
                <div class="col-12">
                    <button class="btn" style="background-color: #8e7cc3;" type="submit">Delete car</button>
                </div>
                <%
                    if (deleteCar != null) {
                        out.println("<h6>Deleted car by id: " + idDelete + deleteCar + "</h6>");
                    } else if (idDelete != null && !idDelete.isBlank()) {
                        out.println("<p class=\"fst-normal\" style=\"color: #d74646;\">A car with this ID does not exist</p>");
                    }
                %>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.example.Car" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <form class="d-flex" role="search">
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
                    String id = request.getParameter("id");
                    if (id == null) {
                        out.println();
                    } else {
                        Car carById = cars.get(id.trim());
                        if (carById != null) {
                            out.println("Car by id " + id + ": " + carById);
                        } else if (id.isBlank()) {
                            Set<String> keys = cars.keySet();
                            for (String key : keys) {
                                Car car = cars.get(key);
                                out.println("<tr><th scope='row'>" + key + " " + printCar(car) + "</th>");
                            }
                        } else {
                            out.println("<p class=\"fst-normal\" style=\"color: #d74646;\">A car with this ID was not found</p>");
                        }
                    }
                %>
                </tbody>
            </table>

            <p>
            <form class="row g-3 needs-validation" novalidate>
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
                String idCreate = request.getParameter("car-id");
                if (idCreate == null || idCreate.isBlank()) {
                    out.println();
                } else {
                    Car carById = cars.get(idCreate);
                    if (carById != null) {
                        out.println("<p class=\"fst-normal\" style=\"color: #d74646;\">Car with this id already exists</p>");
                    } else {
                        String model = request.getParameter("car-model");
                        String number = request.getParameter("car-number");
                        String owner = request.getParameter("car-owner");
                        if (idCreate.isBlank() || model.isBlank() || number.isBlank() || owner.isBlank()) {
                            out.println("<p class=\"fst-normal\" style=\"color: #d74646;\">Fill in all the fields to create a record about your car</p>");
                        } else {
                            cars.put(idCreate, new Car(model, number, owner));
                            out.println("The record of the car was successfully created. ");
                            out.println("New car: ID: " + idCreate +
                                        ", model: " + model +
                                        ", number: " + number +
                                        ", owner: " + owner);
                        }
                    }
                }
            %>

            <p>
            <form class="row g-3">
                <h5>Enter the ID of the car you want to delete</h5>
                <div class="col-md-2">
                    <label for="inputPassword2" class="visually-hidden">Password</label>
                    <input name="id-for-delete" type="text" class="form-control" id="inputPassword2"
                           placeholder="Car ID">
                </div>
                <div class="col-12">
                    <button class="btn" style="background-color: #8e7cc3;" type="submit">Delete car</button>
                </div>
            </form>
            <%
                String idDelete = request.getParameter("id-for-delete");
                if (idDelete == null || idDelete.isBlank()) {
                    out.println();
                } else {
                    Car carById = cars.get(idDelete.trim());
                    if (carById != null) {
                        cars.remove(idDelete);
                        out.println("Deleted car by id: " + idDelete);
                    } else {
                        out.println("<p class=\"fst-normal\" style=\"color: #d74646;\">A car with this ID does not exist</p>");
                    }
                }
            %>

        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>

<%! public String printCar(Car car) {
    return ("<td>" + car.getModel() + "</td><td>" + car.getNumber() + "</td><td>" + car.getOwner() + "</td>");
}
%>

<%! HashMap<String, Car> cars = createHashMap();
%>

<%! public HashMap<String, Car> createHashMap() {
    HashMap<String, Car> cars = new HashMap<>();
    cars.put("1", new Car("BMW", "1111", "Bob"));
    cars.put("2", new Car("AUDI", "2222", "Carl"));
    cars.put("3", new Car("Mercedes", "3333", "Jack"));
    return cars;
}
%>
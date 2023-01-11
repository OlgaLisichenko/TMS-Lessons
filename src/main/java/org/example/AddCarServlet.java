package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {

    public static String addId;
    public static Car addCar;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Car> cars = CarStorage.getCars();

        addId = req.getParameter("car-id");
        if (addId != null) {
            addCar = cars.get(addId.trim());
            if (addCar == null && !addId.isBlank()) {
                String model = req.getParameter("car-model");
                String number = req.getParameter("car-number");
                String owner = req.getParameter("car-owner");
                cars.put(addId.trim(), new Car(model, number, owner));
            }
            req.getRequestDispatcher("/car.jsp").forward(req, resp);
            req.getRequestDispatcher("/cars").forward(req, resp);
        }
    }
}
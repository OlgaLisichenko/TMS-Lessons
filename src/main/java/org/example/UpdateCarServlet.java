package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateCarServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id-for-update");
        String model = req.getParameter("car-model");
        String number = req.getParameter("car-number");
        String owner = req.getParameter("car-owner");
        service.updateCar(new Car(id, model, number, owner));
        req.getRequestDispatcher("/cars").forward(req, resp);
    }
}
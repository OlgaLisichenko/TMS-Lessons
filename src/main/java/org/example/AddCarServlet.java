package org.example;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("car-id");
        if (StringUtils.isNotBlank(id)) {
            String model = req.getParameter("car-model");
            String number = req.getParameter("car-number");
            String owner = req.getParameter("car-owner");
            service.save(new Car(id, model, number, owner));
        }
        req.getRequestDispatcher("/cars").forward(req, resp);
    }
}
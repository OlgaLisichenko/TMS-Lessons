package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class GetCarServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", service.getAll());
        String id = req.getParameter("id");
        req.setAttribute("id", id);
        if (id != null) {
            List<Car> cars = service.getById(id);
            if (cars.size() > 0) {
                Car carById = cars.get(0);
                req.setAttribute("carById", carById);
            }
        }
        req.getRequestDispatcher("/cars.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", service.getAll());
        req.getRequestDispatcher("/cars.jsp").forward(req, resp);
    }
}
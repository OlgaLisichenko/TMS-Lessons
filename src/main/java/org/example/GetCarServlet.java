package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/cars")
public class GetCarServlet extends HttpServlet {

    public static String id;
    public static Car carById;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Car> cars = CarStorage.getCars();

        id = req.getParameter("id");
        if (id != null) {
            carById = cars.get(id.trim());
        }
        req.getRequestDispatcher("/car.jsp").forward(req, resp);
        resp.sendRedirect("/cars");
    }
}
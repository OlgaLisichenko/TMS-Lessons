package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteCarServlet extends HttpServlet {

    public static String idDelete;
    public static Car deleteCar;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        idDelete = req.getParameter("id-for-delete");
        if (idDelete != null) {
            deleteCar = CarStorage.cars.get(idDelete.trim());
            if (deleteCar != null) {
                CarStorage.cars.remove(idDelete.trim());
            }
        }
        req.getRequestDispatcher("/car.jsp").forward(req, resp);
        req.getRequestDispatcher("/cars").forward(req, resp);
    }
}
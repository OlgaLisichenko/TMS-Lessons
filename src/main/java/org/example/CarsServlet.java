package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    private Map<String, Car> cars = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("----------------------do init----------------------");
        cars.put("1", new Car("BMW", "1111", "Bob"));
        cars.put("2", new Car("AUDI", "2222", "Carl"));
        cars.put("3", new Car("Mercedes", "3333", "Jack"));
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("----------------------do service----------------------");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime date = LocalDateTime.now();
        resp.addCookie(new Cookie("Cookie_1", date.format(DateTimeFormatter.ofPattern("HH-mm-ss"))));

        System.out.println("----------------------Cookie----------------------");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("Cookie_1")) {
                System.out.println("The time of the last access to the server: " + cookie.getValue());
            }
        }

        System.out.println("----------------------do get all cars----------------------");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.println("All cars: ");
        System.out.println("All cars: ");

        Set<String> keys = cars.keySet();
        for (String key : keys) {
            Car car = cars.get(key);
            System.out.println(key + " " + car);
            servletOutputStream.println(key + " " + car);
        }

        System.out.println("----------------------do get car by id----------------------");
        String id = req.getParameter("id");
        Car carById = cars.get(id);
        System.out.println("Car by id " + id + " : " + carById);
        servletOutputStream.println("Car by id " + id + " : " + carById);

        //req.getRequestDispatcher("/WEB-INF/book.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("----------------------do post car----------------------");
        PrintWriter respWriter = resp.getWriter();

        String id = req.getParameter("id");
        Car carById = cars.get(id);

        if (id == null || id.isEmpty()) {
            resp.setStatus(400);
        } else if (carById != null) {
            resp.setStatus(400);
            respWriter.println("Car with this id already exists");
        } else {
            String model = req.getParameter("model");
            String number = req.getParameter("number");
            String owner = req.getParameter("owner");

            respWriter.println(id + "=" + "Car {" +
                               "model = '" + model + '\'' +
                               ", number = '" + number + '\'' +
                               ", owner = '" + owner + '\'' +
                               '}');

            cars.put(id, new Car(model, number, owner));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("----------------------do put car----------------------");

        PrintWriter respWriter = resp.getWriter();
        String id = req.getParameter("id");
        Car carById = cars.get(id);

        if (id == null || id.isEmpty()) {
            resp.setStatus(400);
        } else if (carById == null) {
            resp.setStatus(404);
        } else {
            String model = req.getParameter("model");
            String number = req.getParameter("number");
            String owner = req.getParameter("owner");

            respWriter.println(id + "=" + "Car {" +
                               "model = '" + model + '\'' +
                               ", number = '" + number + '\'' +
                               ", owner = '" + owner + '\'' +
                               '}');

            cars.put(id, new Car(model, number, owner));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------------------do delete car by id----------------------");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        String id = req.getParameter("id");
        Car carById = cars.get(id);

        if (id == null || id.isEmpty()) {
            resp.setStatus(400);
        } else if (carById == null) {
            resp.setStatus(404);
        } else {
            cars.remove(id);
            servletOutputStream.println("Deleted car by id " + id + ": " + carById);
            System.out.println("Deleted car by id " + id + ": " + carById);
        }
    }
}
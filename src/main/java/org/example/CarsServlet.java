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
import java.util.Map;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    private static Map<String, Car> cars = Map.of(
            "1", new Car("BMW", "1111", "Bob"),
            "2", new Car("AUDI", "2222", "Carl"),
            "3", new Car("Mercedes", "3333", "Jack"));

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("----------------------do init----------------------");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("----------------------do service----------------------");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        LocalDateTime date = LocalDateTime.now();
        resp.addCookie(new Cookie("JSESSIONID", date.format(DateTimeFormatter.ofPattern("HH-mm-ss"))));

        System.out.println("----------------------Cookie----------------------");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                System.out.println("The time of the last access to the server: " + cookie.getValue());
            }
        }

        System.out.println("----------------------do get all cars----------------------");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        req.setAttribute("cars", cars);
        Object cars1 = req.getAttribute("cars");
        servletOutputStream.println("All cars: " + cars1);
        System.out.println(cars1);

        String id = req.getParameter("id");
        Object o = cars.get(id);
        System.out.println("----------------------do get car by id----------------------");
        System.out.println("Car by id " + id + " : " + o);
        servletOutputStream.println("Car by id " + id + " : " + o);

       // req.getRequestDispatcher("/WEB-INF/book.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("----------------------do post car----------------------");

        PrintWriter respWriter = resp.getWriter();

        String id = req.getParameter("id");
        Car car = new Car();
        String model = req.getParameter("model");
        String number = req.getParameter("number");
        String owner = req.getParameter("owner");

        car.setModel(model);
        car.setNumber(number);
        car.setOwner(owner);

        respWriter.println(id + "=" + "Car {" +
                           "model = '" + model + '\'' +
                           ", number = '" + number + '\'' +
                           ", owner = '" + owner + '\'' +
                           '}');

        cars.put(id, car);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("----------------------do put car----------------------");

        PrintWriter respWriter = resp.getWriter();

        String id = req.getParameter("id");
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------------------do delete car by id----------------------");
        String id = req.getParameter("id");
        cars.remove(id, new Car());
    }
}

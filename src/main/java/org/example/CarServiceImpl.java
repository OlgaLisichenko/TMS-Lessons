package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    StartupServlet servlet = new StartupServlet();

    @Override
    public void save(Car car) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cars(id, model, carNumber, owner)" +
                                                                         " values (?, ?, ?, ?)");
            statement.setString(1, car.getId());
            statement.setString(2, car.getModel());
            statement.setString(3, car.getNumber());
            statement.setString(4, car.getOwner());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("SQL add");
        }
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        Connection connection = servlet.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String model = resultSet.getString("model");
                String number = resultSet.getString("carNumber");
                String owner = resultSet.getString("owner");
                cars.add(new Car(id, model, number, owner));
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL Exception");
        }
        return cars;
    }

    @Override
    public List<Car> getById(String id) {
        List<Car> cars = new ArrayList<>();
        Connection connection = servlet.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE id= ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getString("id");
                String model = resultSet.getString("model");
                String number = resultSet.getString("carNumber");
                String owner = resultSet.getString("owner");
                cars.add(new Car(id, model, number, owner));
            }
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("SQL Exception");
        }
        return cars;
    }

    @Override
    public void deleteCar(String id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cars WHERE id= ?");
            statement.setString(1, id);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("SQL delete");
        }
    }

    @Override
    public void updateCar(Car car) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE cars SET model= ?, carnumber= ?, owner= ?" +
                                                                         " WHERE id= ?");
            statement.setString(1, car.getModel());
            statement.setString(2, car.getNumber());
            statement.setString(3, car.getOwner());
            statement.setString(4, car.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("SQL update");
        }
    }
}
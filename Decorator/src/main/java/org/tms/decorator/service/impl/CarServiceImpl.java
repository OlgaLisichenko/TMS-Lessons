package org.tms.decorator.service.impl;

import org.tms.decorator.config.DBConfig;
import org.tms.decorator.domain.CarEntity;
import org.tms.decorator.service.CarService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarServiceImpl implements CarService {

    DBConfig servlet = new DBConfig();

    @Override
    public void save(CarEntity car) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cars(id, model, carNumber, owner)" +
                                                                         " values (?, ?, ?, ?)");
            statement.setString(1, car.getId());
            statement.setString(2, car.getModel());
            statement.setString(3, car.getNumber());
            statement.setString(4, car.getOwner());
            statement.execute();
            System.out.println("The car " + car + " saved in DB");
        } catch (Exception e) {
            throw new RuntimeException("SQL add");
        }
    }

    @Override
    public void getById(String id) {
        CarEntity car = new CarEntity();
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
                car = new CarEntity(id, model, number, owner);
            }
            statement.execute();
            System.out.println("The car by id " + id + " from DB: " + car);
        } catch (SQLException e) {
            throw new RuntimeException("SQL Exception");
        }
    }

    @Override
    public void deleteCar(String id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cars WHERE id= ?");
            statement.setString(1, id);
            statement.execute();
            System.out.println("The car with id " + id + " deleted from DB");
        } catch (Exception e) {
            throw new RuntimeException("SQL delete");
        }
    }

    @Override
    public void updateCar(CarEntity car) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE cars SET model= ?, carnumber= ?, owner= ?" +
                                                                         " WHERE id= ?");
            statement.setString(1, car.getModel());
            statement.setString(2, car.getNumber());
            statement.setString(3, car.getOwner());
            statement.setString(4, car.getId());
            statement.executeUpdate();
            System.out.println("The car with id " + car.getId() + " updated in DB: " + car);
        } catch (Exception e) {
            throw new RuntimeException("SQL update");
        }
    }
}
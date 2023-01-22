package org.tms.decorator;

import org.tms.decorator.config.DBConfig;
import org.tms.decorator.domain.CarEntity;
import org.tms.decorator.service.CarService;
import org.tms.decorator.service.impl.CacheCarServiceImpl;
import org.tms.decorator.service.impl.CarServiceImpl;

public class Main {
    public static void main(String[] args) {

        DBConfig dbConfig = new DBConfig();
        dbConfig.init();

        CarService service = new CacheCarServiceImpl(new CarServiceImpl());

        CarEntity car1 = new CarEntity("1", "BMW", "1111", "Bob");
        CarEntity car2 = new CarEntity("2", "AUDI", "2222", "Carl");

        service.save(car1);
        service.save(car2);
        service.deleteCar("2");
        service.getById("1");
        service.updateCar(new CarEntity("1", "Toyota", "1234", "John"));
        service.getById("1");
    }
}
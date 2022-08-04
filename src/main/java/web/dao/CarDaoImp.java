package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private static int ID_COUNT;
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(++ID_COUNT, "Audi", "white"));
        cars.add(new Car(++ID_COUNT, "BMW", "blue"));
        cars.add(new Car(++ID_COUNT, "Toyota", "black"));
        cars.add(new Car(++ID_COUNT, "Lada", "white"));
        cars.add(new Car(++ID_COUNT, "Nissan", "orange"));
    }

    public List<Car> index() {
        return cars;
    }


}

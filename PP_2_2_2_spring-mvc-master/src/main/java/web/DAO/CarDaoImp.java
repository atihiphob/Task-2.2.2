package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImp implements CarDao{

    private final List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("001", "someModel_1", 1));
        cars.add(new Car("002", "someModel_2", 2));
        cars.add(new Car("003", "someModel_3", 3));
        cars.add(new Car("004", "someModel_4", 4));
        cars.add(new Car("005", "someModel_5", 5));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> show (int count) {
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(i, cars.get(i));
        }
        return result;
    }
}

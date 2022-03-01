package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.DAO.CarDaoImp;
import web.model.Car;

import java.util.List;

@Component
public class CarServiceImp implements CarService{

    @Autowired
    private CarDaoImp carDaoImp;

    @Override
    public List<Car> getCars() {
        return carDaoImp.getCars();
    }

    @Override
    public List<Car> show(int count) {
        return carDaoImp.show(count);
    }
}

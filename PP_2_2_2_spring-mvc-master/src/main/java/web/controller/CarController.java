package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CarController {

    @GetMapping("/cars")
    public String testMethod (Model model, @RequestParam(value = "count", defaultValue = "0") int count) {
        List <Car> cars = new ArrayList<>();
        cars.add(new Car("001", "someModel_1", 1));
        cars.add(new Car("002", "someModel_2", 2));
        cars.add(new Car("003", "someModel_3", 3));
        cars.add(new Car("004", "someModel_4", 4));
        cars.add(new Car("005", "someModel_5", 5));
        List<Car> result = new ArrayList<>();
        if (count > 0 & count < 5) {
        for (int i = 0; i < count; i++) {
            result.add(i, cars.get(i));
        }
        model.addAttribute("carsList", result);
        } else {
            model.addAttribute("carsList", cars);
        }

        return "cars_index";
    }
}

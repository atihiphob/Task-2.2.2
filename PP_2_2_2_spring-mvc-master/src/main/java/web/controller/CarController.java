package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.NestedServletException;
import web.DAO.CarDao;
import web.DAO.CarDaoImp;
import web.services.CarServiceImp;


@Controller
public class CarController {

    @Autowired
    private CarServiceImp carServiceImp;

    @Autowired
    private CarDaoImp carDaoImp;

    @GetMapping("/cars")
    public String testMethod (Model model, @RequestParam(required = false) Integer count) {
        try {
            if (count < 5 & count >= 0) {
                model.addAttribute("carsList", carDaoImp.show(count));
            } else {
                model.addAttribute("carsList", carServiceImp.getCars());
            }
        } catch (NullPointerException exception) {
            model.addAttribute("carsList", carServiceImp.getCars());
        }

        return "cars_index";
    }
}

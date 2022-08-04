package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping
    public String carsIndex(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null || count > 5) {
            count = 5;
        }
        List<Car> cars = carDao.index().stream().limit(count).toList();
        model.addAttribute("cars", cars);
        return "cars";
    }

}

package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(required = false) Integer count, Model model) {
        model.addAttribute("carsList", carService.setList());

        if (count != null) {
            model.addAttribute("carsList", carService.showByCount(count));
        } else {
            model.addAttribute("carsList", carService.getList());
        }

        return "cars";
    }

}



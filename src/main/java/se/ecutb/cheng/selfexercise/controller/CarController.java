package se.ecutb.cheng.selfexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.ecutb.cheng.selfexercise.data.CarDao;
import se.ecutb.cheng.selfexercise.entity.Car;

import java.time.LocalDate;

@Controller
public class CarController {
    private CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String findAll(Model model){
        model.addAttribute("cars", carDao.findAll());
        return "cars-list";
    }

    @PostMapping("/cars/process")
    public String process(
            @RequestParam("regNumber") String regNumber,
            @RequestParam("brand") String brand,
            @RequestParam("mode") String mode,
            @RequestParam("regDate") String regDate
    ){
        Car newCar = new Car(
                regNumber,
                brand,
                mode,
                LocalDate.parse(regDate)
        );
        carDao.save(newCar);

        return "redirect:/cars";
    }

    @GetMapping("cars/create")
    public String create(){return "car-form";}

    @GetMapping("cars/find")
    public String findById(@RequestParam("id") int id, Model model){
        Car car = carDao.findById(id).get();
        model.addAttribute("car", car);
        return "car-details";
    }

    @PostMapping("cars/delete")
    public String delete(@RequestParam("id") int id){
        carDao.delete(id);
        return "redirect:/cars";
    }
}

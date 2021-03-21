package com.example.mvctask.controllers;

import com.example.mvctask.dao.CarDAO;
import com.example.mvctask.models.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CarController {

    private CarDAO carDAO;

    @PostMapping("/save")
    public String saveCar(@RequestParam("model") String carmodel, Model model) {
        carDAO.save(new Car(carmodel));
        model.addAttribute("cars", carDAO.findAll());
        return "cars.html";
    }

    @GetMapping("/cars/{id}")
    public String getCar(@PathVariable int id, Model model) {
        Car one = carDAO.getOne(id);
        model.addAttribute("car", one);
        return "car.html";
    }
}

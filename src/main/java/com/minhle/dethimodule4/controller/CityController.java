package com.minhle.dethimodule4.controller;

import com.minhle.dethimodule4.model.City;
import com.minhle.dethimodule4.model.Country;
import com.minhle.dethimodule4.service.ICityService;
import com.minhle.dethimodule4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ModelAndView showAll() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("city/index");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/add-new")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("city/add");
        Iterable<Country> countries = countryService.findAll();
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/add-new")
    public String addNewCity(@ModelAttribute City city) {
        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("/show-city/{cityName}")
    public ModelAndView showOneCity(@PathVariable("cityName") String cityName) {
        City city = cityService.findCityByName(cityName);
        ModelAndView modelAndView = new ModelAndView("/city/city-detail");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
}

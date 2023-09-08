package com.microservice.driver.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.microservice.driver.dao.DriverDao;
import com.microservice.driver.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/driver")
public class DriverController {

    @Autowired
    private DriverDao driverDao;

    @GetMapping
    public List<Driver> listeALLDrivers(@RequestParam(value = "firstName", required = false) String firstName,
                                        @RequestParam(value = "lastName", required = false) String lastName) {

        if (firstName == null && lastName == null){
            List<Driver> drivers = driverDao.findAll();
            return drivers;
        } else if (firstName == null){
           return driverDao.findByLastName(lastName);
        } else {
            return  driverDao.findByFirstName(firstName);
        }

    }


    @GetMapping(value = "/{id}")
    public Driver showOneDriver(@PathVariable int id) {
        return driverDao.findById(id);
    }


    @PostMapping
    public Driver addDriver(@RequestBody Driver driver) {
        return driverDao.save(driver);
    }

    @PutMapping(value = "/{id}")
    public Driver updateDriver(@RequestBody Driver driver, @PathVariable int id) {
        driver.setId(id);
        return driverDao.save(driver);
    }

    @DeleteMapping(value = "/{id}")
    public Driver deleteDriver(@PathVariable int id) {
        return driverDao.deleteById(id);
    }

}

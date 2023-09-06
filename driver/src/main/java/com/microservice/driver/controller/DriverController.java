package com.microservice.driver.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.microservice.driver.dao.DriverDao;
import com.microservice.driver.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/driver")
public class DriverController {

    @Autowired
    private DriverDao driverDao;

    @GetMapping
    public MappingJacksonValue listeDriver() {
        Iterable<Driver> driver = driverDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue driverFiltres = new MappingJacksonValue(driver);

        driverFiltres.setFilters(listDeNosFiltres);

        return driverFiltres;
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

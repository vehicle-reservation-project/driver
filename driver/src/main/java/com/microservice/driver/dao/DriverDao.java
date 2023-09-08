package com.microservice.driver.dao;

import com.microservice.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverDao extends JpaRepository<Driver, Integer> {

    Driver findById(int id);

    Driver save(Driver driver);

    Driver deleteById(int id);
    List<Driver> findByFirstName(String firstName);
    List<Driver> findByLastName(String lastName);
}

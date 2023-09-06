package com.microservice.driver.dao;

import com.microservice.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDao extends JpaRepository<Driver, Integer> {

    Driver findById(int id);

    Driver save(Driver driver);

    Driver deleteById(int id);
}

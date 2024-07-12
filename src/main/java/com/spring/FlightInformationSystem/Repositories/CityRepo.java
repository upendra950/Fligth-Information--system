package com.spring.FlightInformationSystem.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.FlightInformationSystem.Entities.City;

public interface CityRepo extends JpaRepository<City,Integer> {

    City getByCityCode(String fromCity);

    void deleteAllByCityCode(String cityCode);

    String findByCityCode(String cityCode);
    @Query("select cityCode from City")
    List<String > findCityCode();
    
}

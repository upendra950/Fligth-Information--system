package com.spring.FlightInformationSystem.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.FlightInformationSystem.Entities.Flight;

public interface FlightRepo extends JpaRepository<Flight,String>{

   

    List<Flight> findByFromCityCityCodeAndToCityCityCode(String fromCityCode, String toCityCode);

    List<Flight> findAllByFlightNo(String flightNo);
    @Query("select flightNo from Flight")
    List<String> getFlightNo();
    
}

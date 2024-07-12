package com.spring.FlightInformationSystem.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.FlightInformationSystem.Entities.ScheduledFlight;

public interface ScheduleFlightRepo extends JpaRepository<ScheduledFlight,Long> {


    List<ScheduledFlight> findAllByDepartureDateAndFromCityCityCode(LocalDate departurDate,String fromCity);
    List<ScheduledFlight> findByDepartureDateBetween(LocalDate departureDate1,LocalDate departureDate2);
    //List<ScheduledFlight> findByDepartureDateAndDepartureTimeBefore(LocalDate departureDate,LocalTime departureTime);
    
    
}

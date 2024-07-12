package com.spring.FlightInformationSystem.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.FlightInformationSystem.Entities.Flight;
import com.spring.FlightInformationSystem.Entities.FlightHistory;

public interface FlightHistoryRepo extends JpaRepository<FlightHistory,Long>{


    List<FlightHistory> findByFlightFlightNo(String flightNo);
    // @Query(value="select fh.* from flight_history fh JOIN flight f on f.flight_no = fh.flight_no  where abs(fh.duration_minutes-f.duration_minutes)=:minutes",nativeQuery=true)
    // List<FlightHistory> findAllDelayedFlightHistory(@Param("minutes")int minutes );
    
    @Query("select fh from FlightHistory fh join fh.flight f where abs(fh.durationMinutes - f.durationMinutes) = :minutes")
List<FlightHistory> findAllDelayedFlightHistory(@Param("minutes") int minutes);

@Query("select flight from FlightHistory")
  List<Flight> getFlightNo();
}

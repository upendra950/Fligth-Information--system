package com.spring.FlightInformationSystem.RestControllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.FlightInformationSystem.Entities.Flight;
import com.spring.FlightInformationSystem.Repositories.CityRepo;
import com.spring.FlightInformationSystem.Repositories.FlightRepo;
import com.spring.FlightInformationSystem.dto.FlightResponseDto;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightRepo flightRepo;
    @Autowired
    CityRepo cityRepo;


    @GetMapping("/get-All-Flights")
    public List<FlightResponseDto> getFlight(){
        try{
        List<Flight> allFlights = flightRepo.findAll();
        List<FlightResponseDto> allFlightsRes = new ArrayList<>();
        if(allFlights.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"data not availble");
        }
        for(Flight f : allFlights){
            FlightResponseDto frd = new FlightResponseDto();
            frd.setFlightNo(f.getFlightNo());
            frd.setFromCity(f.getFromCity().getCityCode());
            frd.setToCity(f.getToCity().getCityCode());
            frd.setDurationMinutes(f.getDurationMinutes());
            frd.setDepartureTime(f.getDepartureTime());
            frd.setArrivalTime(f.getArrivalTime());
            frd.setAircraft(f.getAircraft());
            
            allFlightsRes.add(frd);
        }
        return allFlightsRes;}
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An Internal Server Occured");
        }



    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add-Flight")
    // @PreAuthorize("hasRole('ADMIN')")
    public void addFlight( @RequestBody Flight flight1,@RequestParam("fromCity") String fromCity,@RequestParam("toCity") String toCity){
       try{
        String f=flight1.getFlightNo();  
        List<String> allFlights=flightRepo.getFlightNo();
        if(allFlights.contains(f)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"flight  number allready exists");  
        }
        Flight flight =new Flight();
        flight.setFromCity(cityRepo.getByCityCode(fromCity));
        flight.setToCity(cityRepo.getByCityCode(toCity));
         flight.setFlightNo(flight1.getFlightNo());
         flight.setAircraft(flight1.getAircraft());
         flight.setDurationMinutes(flight1.getDurationMinutes());
         flight.setDepartureTime(flight1.getDepartureTime());
         flight.setArrivalTime(flight1.getArrivalTime());
        flightRepo.save(flight);}
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An internal server occured"+e.getMessage(),e);
        }
    }
    @GetMapping("/FlightsByPages/{pageNo}/{pageSize}")
    public List<FlightResponseDto> getFlightsByPages(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
        Pageable pages=PageRequest.of(pageNo, pageSize);
        List<Flight> allFlights = flightRepo.findAll(pages).getContent();

        List<FlightResponseDto> allFlightsRes = new ArrayList<>();
        for(Flight f : allFlights){
            FlightResponseDto frd = new FlightResponseDto();
            frd.setFlightNo(f.getFlightNo());
            frd.setFromCity(f.getFromCity().getCityCode());
            frd.setToCity(f.getToCity().getCityCode());
            frd.setDurationMinutes(f.getDurationMinutes());
            frd.setDepartureTime(f.getDepartureTime());
            frd.setArrivalTime(f.getArrivalTime());
            frd.setAircraft(f.getAircraft());
            
            allFlightsRes.add(frd);
        }

        return allFlightsRes;
    }
    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/flights-Fromcity-Tocity")
    public List<Flight> getFlightFromCityToCity(@RequestParam("fromCity") String fromcity,@RequestParam("toCity") String toCity){
        try{
        List<Flight> f=flightRepo.findByFromCityCityCodeAndToCityCityCode(fromcity,toCity);
        if(f.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No data found");
        }
        return f;    
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An Internal server Occured"+e.getMessage(),e);
    }

        

    }
    
}

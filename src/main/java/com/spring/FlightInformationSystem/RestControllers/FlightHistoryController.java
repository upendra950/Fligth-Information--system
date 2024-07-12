package com.spring.FlightInformationSystem.RestControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.FlightInformationSystem.Entities.City;
import com.spring.FlightInformationSystem.Entities.Flight;
import com.spring.FlightInformationSystem.Entities.FlightHistory;
import com.spring.FlightInformationSystem.Repositories.CityRepo;
import com.spring.FlightInformationSystem.Repositories.FlightHistoryRepo;
import com.spring.FlightInformationSystem.Repositories.FlightRepo;
import com.spring.FlightInformationSystem.dto.FlightHistoryDto;


@RestController
public class FlightHistoryController {

    @Autowired
    FlightHistoryRepo flightHistoryRepo;

    @Autowired
    CityRepo cityRepo;
    
    @Autowired
    FlightRepo flightRepo;

    @GetMapping("flightHistory-flightNo")
    public List<FlightHistoryDto> getFlightHistoryByFlightNo(@RequestParam("flightNo")String flightNo){
        try{
        List<FlightHistory> flight= flightHistoryRepo.findByFlightFlightNo(flightNo);
        List<FlightHistoryDto> flightHisDto=new ArrayList<>();
        if(flight.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"no data found");
        }
        for (FlightHistory a : flight) {
            FlightHistoryDto d=new FlightHistoryDto();
            d.setFlightHistoryId(a.getFlightHistoryId());
            d.setFlight(a.getFlight().getFlightNo());
            d.setFromCity(a.getFromCity().getCityCode());
            d.setToCity(a.getToCity().getCityCode());
            d.setDepartureDate(a.getDepartureDate());
            d.setDepartureTime(a.getDepartureTime());
            d.setArrivalDate(a.getArrivalDate());
            d.setArrivalTime(a.getArrivalTime());
            d.setDurationMinutes(a.getDurationMinutes());
            d.setAircraft(a.getAircraft());
            d.setRemarks(a.getRemarks());
            flightHisDto.add(d);}

        return flightHisDto;}
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An internal server occured"+e.getMessage(),e);
        }
      
    }

    
    @GetMapping("/get-allFlightHistory")
    public List<FlightHistoryDto> getFlightHistory(){
        try{
        List<FlightHistory> allFlightHis=flightHistoryRepo.findAll();
        List<FlightHistoryDto> flightHistoryDto=new ArrayList<>();
        if(allFlightHis.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"data not availble");
        }
        for (FlightHistory a : allFlightHis) {
            FlightHistoryDto d=new FlightHistoryDto();
            d.setFlightHistoryId(a.getFlightHistoryId());
            d.setFlight(a.getFlight().getFlightNo());
            d.setFromCity(a.getFromCity().getCityCode());
            d.setToCity(a.getToCity().getCityCode());
            d.setDepartureDate(a.getDepartureDate());
            d.setDepartureTime(a.getDepartureTime());
            d.setArrivalDate(a.getArrivalDate());
            d.setArrivalTime(a.getArrivalTime());
            d.setDurationMinutes(a.getDurationMinutes());
            d.setAircraft(a.getAircraft());
            d.setRemarks(a.getRemarks());
            flightHistoryDto.add(d);

            
        }
        return flightHistoryDto;}
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An internal server occured"+e.getMessage(),e);
        }


    }
    
    @PostMapping("/add")
    // @PreAuthorize("hasRole('ADMIN')")
    public void  addFlightHistory(@RequestParam("fromCity") String fromCity,
                                @RequestParam("toCity") String toCity,
                                 @RequestParam("flight") String flight,
                                 @RequestBody FlightHistory flightHistory){

        FlightHistory f=new FlightHistory();
        City fromCitycode=cityRepo.getByCityCode(fromCity);
        City toCityCode =cityRepo.getByCityCode(toCity);

        f.setFromCity(fromCitycode);
        f.setToCity(toCityCode);

        Flight flightnumber=flightRepo.findById(flight).orElseThrow(()-> new IllegalArgumentException("Flight  not found"));
        f.setFlight(flightnumber);

        f.setDurationMinutes(flightHistory.getDurationMinutes()); 
        f.setDepartureDate(flightHistory.getDepartureDate());
        f.setDepartureTime(flightHistory.getDepartureTime());
        f.setArrivalTime(flightHistory.getArrivalTime());
        f.setArrivalDate(flightHistory.getArrivalDate());
        f.setAircraft(flightHistory.getAircraft());
        f.setRemarks(flightHistory.getRemarks());
        flightHistoryRepo.save(f);
        
    }

    @GetMapping("/delayed Flight-History-byMinutes")
    public List<FlightHistoryDto> getDelayedFlightHistoryByMinutes(@RequestParam("minutes") int minutes){
        try{
        List<FlightHistory> allFlights=flightHistoryRepo.findAllDelayedFlightHistory(minutes);
        List<FlightHistoryDto> fDto=new ArrayList<>();
        if(allFlights.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"data not availble");
        }
        for (FlightHistory a : allFlights) {
            FlightHistoryDto d=new FlightHistoryDto();
            d.setFlightHistoryId(a.getFlightHistoryId());
            d.setFlight(a.getFlight().getFlightNo());
            d.setFromCity(a.getFromCity().getCityCode());
            d.setToCity(a.getToCity().getCityCode());
            d.setDepartureDate(a.getDepartureDate());
            d.setDepartureTime(a.getDepartureTime());
            d.setArrivalDate(a.getArrivalDate());
            d.setArrivalTime(a.getArrivalTime());
            d.setDurationMinutes(a.getDurationMinutes());
            d.setAircraft(a.getAircraft());
            d.setRemarks(a.getRemarks());
            fDto.add(d);

            
        }   
        
        return  fDto;}
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An Internal server occured"+e.getMessage(),e);
        }

    }
    
}

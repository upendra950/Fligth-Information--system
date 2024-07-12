package com.spring.FlightInformationSystem.RestControllers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.FlightInformationSystem.Entities.City;
import com.spring.FlightInformationSystem.Entities.Flight;
import com.spring.FlightInformationSystem.Entities.ScheduledFlight;
import com.spring.FlightInformationSystem.Repositories.CityRepo;
import com.spring.FlightInformationSystem.Repositories.FlightHistoryRepo;
import com.spring.FlightInformationSystem.Repositories.FlightRepo;
import com.spring.FlightInformationSystem.Repositories.ScheduleFlightRepo;
import com.spring.FlightInformationSystem.dto.ScheduledFlightDto;

@RestController
@RequestMapping("/scheduleflight")
public class ScheduleFlightController {

    @Autowired
    ScheduleFlightRepo scheduleFlightRepo;

    @Autowired
    CityRepo cityRepo;

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    FlightHistoryRepo flightHistoryRepo;


  
    @GetMapping("/get")
    public List<ScheduledFlightDto> getFlightSchedule(){
        try{
     
        List<ScheduledFlight> allschedule=scheduleFlightRepo.findAll();
        List<ScheduledFlightDto> scheduleDto=new ArrayList<>();
        if(allschedule.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Data not availble");
        }

        for (ScheduledFlight sf: allschedule) {
            ScheduledFlightDto ad=new ScheduledFlightDto();

            ad.setFlight(sf.getFlight().getFlightNo());
            ad.setFromCity(sf.getFromCity().getCityCode());
            ad.setToCity(sf.getToCity().getCityCode());
            ad.setScheduleId(sf.getScheduleId());
            ad.setArrivalDate(sf.getArrivalDate());
            ad.setArrivalTime(sf.getArrivalTime());
            ad.setDepartureDate(sf.getDepartureDate());
            ad.setDepartureTime(sf.getDepartureTime());
            ad.setDurationMinutes(sf.getDurationMinutes());
            ad.setStatus(sf.getStatus());
            scheduleDto.add(ad);

        }

        return  scheduleDto;}
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An internal server occured "+e.getMessage(),e);
        }

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getScheduledFlights-by-date and fromCity")
    public List<ScheduledFlightDto> gScheduledFlightsByDateAndFromCity(@RequestParam("departureDate") LocalDate departureDate,
                                                                    @RequestParam("fromCity") String fromCity){
    try{
     List<ScheduledFlight> schFlight=scheduleFlightRepo.findAllByDepartureDateAndFromCityCityCode(departureDate,fromCity);
     List<ScheduledFlightDto> schDto=new ArrayList<>();
     if(schFlight.isEmpty()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Data not availble");
    }
     for (ScheduledFlight a : schFlight) {
        ScheduledFlightDto ad=new ScheduledFlightDto();
        ad.setFlight(a.getFlight().getFlightNo());
        ad.setFromCity(a.getFromCity().getCityCode());
        ad.setToCity(a.getToCity().getCityCode());
        ad.setScheduleId(a.getScheduleId());
        ad.setArrivalDate(a.getArrivalDate());
        ad.setArrivalTime(a.getArrivalTime());
        ad.setDepartureDate(a.getDepartureDate());
        ad.setDepartureTime(a.getDepartureTime());
        ad.setDurationMinutes(a.getDurationMinutes());
        ad.setStatus(a.getStatus());
        schDto.add(ad);
        
     }
     return schDto;}
     catch(Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An internal server occured "+e.getMessage(),e);
    }

    }


    @PostMapping("/add")
    // @PreAuthorize("hasRole('ADMIN')")
    public void addScheduleFlight(@RequestParam("fromCity") String fromCity,
                                  @RequestParam("toCity") String toCity,
                                  @RequestParam("flight") String flight,
                                  @RequestBody ScheduledFlight scheduledFlight1){
       
            ScheduledFlight s = new ScheduledFlight();

            City fromCitycode=cityRepo.getByCityCode(fromCity);
            City toCityCode =cityRepo.getByCityCode(toCity);

          s.setFromCity(fromCitycode);
          s.setToCity(toCityCode);
          Flight flightnumber=flightRepo.findById(flight).orElseThrow(()-> new IllegalArgumentException("Flight  not found"));
          s.setFlight(flightnumber);

          s.setDurationMinutes(scheduledFlight1.getDurationMinutes());
           s.setDepartureTime(scheduledFlight1.getDepartureTime());
           s.setArrivalTime(scheduledFlight1.getArrivalTime());
           s.setDepartureDate(scheduledFlight1.getDepartureDate());
           s.setArrivalDate(scheduledFlight1.getArrivalDate());
           if(scheduledFlight1.getStatus()==null){
           s.setStatus("Active");}
           
           scheduleFlightRepo.save(s);
                                  
    }
    @PostMapping("/add-flights-upon-two-dates")
    // @PreAuthorize("hasRole('ADMIN')")
    public void addFlightUponTwodates(@RequestParam("arrivalDate") LocalDate arrivalDate,
                                       @RequestParam("departureDate") LocalDate departurDate,
                                       @RequestParam("flightNo") String flightNo ){
            
    List<Flight> allFlight=flightRepo.findAllByFlightNo(flightNo);
    ScheduledFlight sc=new ScheduledFlight();
    sc.setArrivalDate(arrivalDate);
    sc.setDepartureDate(departurDate);
    for (Flight a :allFlight) {
        sc.setArrivalTime(a.getArrivalTime());
        sc.setDepartureTime(a.getDepartureTime());
        sc.setFlight(a);
        sc.setFromCity(a.getFromCity());
        sc.setToCity(a.getToCity());
        sc.setDurationMinutes(a.getDurationMinutes()); 
        sc.setStatus("Active");
    }
    scheduleFlightRepo.save(sc);
 }
    @PutMapping("/cancel-scheduleFlight-by-dates/{departureDate1}/{departureDate2}")
    // @PreAuthorize("hasRole('ADMIN')")
    public void cancelScheduleFlightByDates(@PathVariable("departureDate1") LocalDate departurDate1,
    @PathVariable("departureDate2") LocalDate departurDate2){
        try{
        
        List<ScheduledFlight> schFlight=scheduleFlightRepo.findByDepartureDateBetween(departurDate1,departurDate2);
        if(schFlight.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Data not availble");
        }
        for (ScheduledFlight s : schFlight) {
            System.out.println(s.toString());
            s.setStatus("cancelled");
            scheduleFlightRepo.save(s);
            
        }
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An internal server occured "+e.getMessage(),e);
    }
        
    }


}


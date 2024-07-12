package com.spring.FlightInformationSystem.RestControllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.FlightInformationSystem.Entities.City;
import com.spring.FlightInformationSystem.Repositories.CityRepo;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityRepo cityRepo;


    @PostMapping("/add")
    // @PreAuthorize("hasRole('ADMIN')")
    public void addCity(@RequestBody City city){
        try{
        List<String> existing=cityRepo.findCityCode();
        if(existing.contains(city.getCityCode())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"city code alredy exists");

        }
        cityRepo.save(city);}
        catch(DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"data Intigrity violation:"+e.getMessage(),e);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"An unexpected error occured:"+e.getMessage(),e);
        }
    }
    
    // @CrossOrigin(origins="http://localhost:4200")
    @GetMapping("/getallcities")
    public List<City> getCity(){
        try{

        List<City> allCities=cityRepo.findAll();  
        if(allCities.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"no Data found");
        }
        return allCities;
    } catch(Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An Interval Server"+e.getMessage(),e);
    }
       
    }
     @DeleteMapping("/{cityCode}")
    //  @PreAuthorize("hasRole('ADMIN')")
    public void deleteCityByCityCode(@PathVariable("cityCode") String cityCode) {
        try {
            City city = cityRepo.getByCityCode(cityCode);
            if (city == null) {
                
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"city code not found");
            } 
                cityRepo.delete(city);
               
         
        } catch (DataAccessException e) {
        //log.error("An error occurred while accessing the database: {}", e.getMessage());
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "An internal server error occurred"+e.getMessage(),e);
    }
        
        catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An Internal Servor Occured :"+e.getMessage(),e);
        }
    }
    @PutMapping("/update-city/{cityCode}")
    // @PreAuthorize("hasRole('ADMIN')")
    public void updateCities(@PathVariable String cityCode,@RequestBody City city){
        City c=cityRepo.getByCityCode(cityCode);
        List<String> s=cityRepo.findCityCode(); 
        try{
            if(!s.contains(cityCode)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"city code not found");
            }
            c.setCityName(city.getCityName());
            c.setCountry(city.getCountry());
            c.setMinutesFromUtc(city.getMinutesFromUtc());
            cityRepo.save(c);

        }
       catch(Exception e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"An Internal Server Occured"+e.getMessage(),e);
       }

    }
}

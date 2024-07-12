package com.spring.FlightInformationSystem.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ScheduledFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private long scheduleId;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name="departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
     
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "from_city_code")
    private City fromCity;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "to_city_code")
    private City toCity;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "flight_no")
    private Flight flight;

    @Column(name = "duration_minutes")
    private int durationMinutes;
    
    @Column(name = "status",nullable = false,columnDefinition = "varchar(255)DEFAUlT'Active'")
    private String status;


    
    

    public ScheduledFlight() {
    }
     

    
    public ScheduledFlight(LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate,
        LocalTime arrivalTime, City fromCity, City toCity, Flight flight, int durationMinutes,String status) {
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.flight = flight;
        this.durationMinutes = durationMinutes;
        this.status =  status ;
    }



    public long getScheduleId() {
        return scheduleId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departurDate) {
        this.departureDate = departurDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public void setToCity(City toCity) {
        this.toCity = toCity;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    
    
    


   
    
    
}

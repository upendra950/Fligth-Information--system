package com.spring.FlightInformationSystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;


public class ScheduledFlightDto {

    private long scheduleId;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private int durationMinutes;
    private String  flight;
    private String fromCity;
    private String toCity;
    private String status;


    public ScheduledFlightDto() {
    }

    
    public long getScheduleId() {
        return scheduleId;
    }


    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
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


    public LocalDate getDepartureDate() {
        return departureDate;
    }


    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }


    public LocalTime getDepartureTime() {
        return departureTime;
    }


    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }


    public int getDurationMinutes() {
        return durationMinutes;
    }


    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }


    public String getFlight() {
        return flight;
    }


    public void setFlight(String flight) {
        this.flight = flight;
    }


    public String getFromCity() {
        return fromCity;
    }


    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }


    public String getToCity() {
        return toCity;
    }


    public void setToCity(String toCity) {
        this.toCity = toCity;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }







    
}

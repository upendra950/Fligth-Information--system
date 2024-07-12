package com.spring.FlightInformationSystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightHistoryDto {
    private Long flightHistoryId;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private int durationMinutes;
    private String fromCity;
    private String toCity;
    private String aircraft;
    private String remarks;
    private String flight;

    
    public FlightHistoryDto() {
    }
    public Long getFlightHistoryId() {
        return flightHistoryId;
    }
    public void setFlightHistoryId(Long flightHistoryId) {
        this.flightHistoryId = flightHistoryId;
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
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
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
    public String getAircraft() {
        return aircraft;
    }
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getFlight() {
        return flight;
    }
    public void setFlight(String flight) {
        this.flight = flight;
    }

    







}

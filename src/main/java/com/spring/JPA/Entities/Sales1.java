package com.spring.JPA.Entities;


import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;


@Entity
public class Sales1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sales_id;
    private String ord_num;
    private LocalDate ord_date;
    private int qty;
    private String payments;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Products1 product;

    
    
    
    public  Sales1(){}




    public Sales1( String ord_num, LocalDate ord_date, int qty, String payments, Products1 product) {
        //this.sales_id = sales_id;
        this.ord_num = ord_num;
        this.ord_date = ord_date;
        this.qty = qty;
        this.payments = payments;
        this.product = product;
    }




    public int getSales_id() {
        return sales_id;
    }




    public String getOrd_num() {
        return ord_num;
    }




    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
    }




    public LocalDate getOrd_date() {
        return ord_date;
    }




    public void setOrd_date(LocalDate ord_date) {
        this.ord_date = ord_date;
    }




    public int getQty() {
        return qty;
    }




    public void setQty(int qty) {
        this.qty = qty;
    }




    public String getPayments() {
        return payments;
    }




    public void setPayments(String payments) {
        this.payments = payments;
    }




    public Products1 getProduct() {
        return product;
    }




    public void setProduct(Products1 product) {
        this.product = product;
    }




    @Override
    public String toString() {
        return "Sales1 [sales_id=" + sales_id + ", ord_num=" + ord_num + ", ord_date=" + ord_date + ", qty=" + qty
                + ", payments=" + payments + ", product=" + product + "]";
    }

        

}
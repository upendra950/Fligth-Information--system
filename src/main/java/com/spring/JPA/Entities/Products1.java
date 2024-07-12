package com.spring.JPA.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Products1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private String prodName;
    private double price;
    private int qoh;
    private String remarks;
    private double taxRate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<Sales1> sales1;

    
    public Products1() {
    }


    public Products1( String prodName, double price, int qoh, String remarks, double taxRate
          ) {
        //this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
        this.qoh = qoh;
        this.remarks = remarks;
        this.taxRate = taxRate;
       
    }


    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }


    public void setProdName(String prodName) {
        this.prodName = prodName;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public int getQoh() {
        return qoh;
    }


    public void setQoh(int qoh) {
        this.qoh = qoh;
    }


    public String getRemarks() {
        return remarks;
    }


    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public double getTaxRate() {
        return taxRate;
    }


    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }


    public List<Sales1> getSales1() {
        return sales1;
    }


    public void setSales1(List<Sales1> sales1) {
        this.sales1 = sales1;
    }


    @Override
    public String toString() {
        return "Products1 [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", qoh=" + qoh
                + ", remarks=" + remarks + ", taxRate=" + taxRate +  "]";
    }
   
    


    
    
   
    
    
}

package com.spring.SpringRest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products2 {
    @Id
    private int prodId;
    private String prodName;
    private double price;
    private int qoh;
    private String remarks;
    private double taxRate;

    @ManyToOne
    @JoinColumn(name="catCode")
    //@JsonIgnore
    private Categories2 category;

    // Constructors
    public Products2() {
    }

    public Products2(int prodId, String prodName, double price, int qoh, String remarks, double taxRate,Categories2 category) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
        this.qoh = qoh;
        this.remarks = remarks;
        this.taxRate = taxRate;
        this.category=category;
    }

    // Getters and Setters
    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
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

    public Categories2 getCategory() {
        return category;
    }

    public void setCategory(Categories2 category) {
        this.category = category;
    }

    // toString method
    @Override
    public String toString() {
        return "Products2{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                ", qoh=" + qoh +
                ", remarks='" + remarks + '\'' +
                ", taxRate=" + taxRate +
                ", category=" + category +
                '}';
    }
}

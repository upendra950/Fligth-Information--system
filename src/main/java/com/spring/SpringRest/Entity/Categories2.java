package com.spring.SpringRest.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categories2 {
    @Id
    private String catCode;
    private String catDesc;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "category")
    @JsonIgnore
    private List<Products2> products;

    // Constructors
    public Categories2() {
    }

    public Categories2(String catCode, String catDesc) {
        this.catCode = catCode;
        this.catDesc = catDesc;
    }

    // Getters and Setters
    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public List<Products2> getProducts() {
        return products;
    }

    public void setProducts(List<Products2> products) {
        this.products = products;
    }

    // toString method
    @Override
    public String toString() {
        return "Categories2{" +
                "catCode='" + catCode + '\'' +
                ", catDesc='" + catDesc + '\'' +
                ", products=" + 
                '}';
    }
}

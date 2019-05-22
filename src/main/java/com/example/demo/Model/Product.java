package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int product_id;
    private String product_description;
    private double product_price_per_kg;
    private int product_amount;

    public Product(){
    }

    public Product(int product_id, String product_description, double product_price_per_kg, int product_amount){
        this.product_id = product_id;
        this.product_description = product_description;
        this.product_price_per_kg = product_price_per_kg;
        this.product_amount = product_amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_description() { return product_description; }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getProduct_price_per_kg() {
        return product_price_per_kg;
    }

    public void setProduct_price_per_kg(double product_price_per_kg) {
        this.product_price_per_kg = product_price_per_kg;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }
}

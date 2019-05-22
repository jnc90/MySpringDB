package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Line_Order {
    @Id
    private int line_id;
    private int order_id;
    private int product_id;
    private double line_price;
    private int line_amount;

    public Line_Order(){
    }

    public Line_Order(int line_id, int order_id, int product_id, double line_price, int line_amount){
        this.line_id = line_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.line_price = line_price;
        this.line_amount = line_amount;
    }

    public int getLine_id() {
        return line_id;
    }

    public void setLine_id(int line_id) {
        this.line_id = line_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getLine_price() {
        return line_price;
    }

    public void setLine_price(double line_price) {
        this.line_price = line_price;
    }

    public int getLine_amount() {
        return line_amount;
    }

    public void setLine_amount(int line_amount) {
        this.line_amount = line_amount;
    }
}

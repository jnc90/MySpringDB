package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.sql.*;
import java.util.Calendar;
import java.lang.Object.*;


@Entity
public class Order {
    @Id
    private int order_id;
    private int vendor_id;
    //private java.sql.Timestamp order_date; //Er Date den rigtige datatype at bruge?  Timestamp??

    private double total_price;

    public Order() {

    }

    public Order(int order_id, int vendor_id, double total_price) {
        this.order_id = order_id;
        this.vendor_id = vendor_id;
        //this.order_date = order_date;
        this.total_price = total_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }



  /*  public java.sql.Timestamp getOrder_date() {
       Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(stamp.getTime());
        System.out.println(date)


        System.out.println("order_date:  " + order_date);
        return order_date; }
        */

    public java.sql.Timestamp getOrderTimeStamp() {
        java.util.Date currentTime = new java.util.Date();
        System.out.println("currentTime:  " + currentTime );
        System.out.println("currentTime.getTime(): " + currentTime.getTime());
        return new java.sql.Timestamp(currentTime.getTime());
    }

   // public void setOrder_date(String order_date) { this.order_date = order_date; }

    public double getTotal_price() { return total_price; }

    public void setTotal_price(double total_price) { this.total_price = total_price; }
}

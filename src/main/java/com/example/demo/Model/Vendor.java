package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {
    @Id
    private int vendor_id;
    private String name;
    private String phone;
    private String email;
    private int zip_code;
    private String city;

    public Vendor(){
    }

    public Vendor(int vendor_id, String name, String phone, String email, int zip_code, String city){
        this.vendor_id = vendor_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.zip_code = zip_code;
        this.city = city;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {
    @Id
    private int vendor_id;
    private String vendor_name;
    private String phone;
    private String email;
    private int zip_code_id;
    private String address;

    public Vendor(){
    }

    public Vendor(int vendor_id, String vendor_name, String phone, String email, int zip_code, String address){
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.phone = phone;
        this.email = email;
        this.zip_code_id = zip_code_id;
        this.address = address;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip_code_id() { return zip_code_id;
    }

    public void setZip_code_id(int zip_code_id) {
        this.zip_code_id = zip_code_id;
    }

}

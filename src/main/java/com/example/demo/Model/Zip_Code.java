package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Zip_Code {
    @Id
    private int zip_code_id;
    private int zip_code;
    private String city;

    public Zip_Code(){
    }

    public Zip_Code(int zip_code_id, int zip_code, String city){
        this.zip_code_id = zip_code_id;
        this.zip_code = zip_code;
        this.city = city;
    }

    public int getZip_code_id() {
        return zip_code_id;
    }

    public void setZip_code_id(int zip_code_id) {
        this.zip_code_id = zip_code_id;
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

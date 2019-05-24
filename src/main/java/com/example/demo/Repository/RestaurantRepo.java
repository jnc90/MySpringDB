package com.example.demo.Repository;

import com.example.demo.Model.Line_Order;
import com.example.demo.Model.Product;
import com.example.demo.Model.Vendor;
import com.example.demo.Model.Zip_Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RestaurantRepo {
    @Autowired
    JdbcTemplate template;

    public List<Zip_Code> fetchAllCodes(){
        String sql = "SELECT * FROM Zip_Codes";
        RowMapper<Zip_Code> rowMapper = new BeanPropertyRowMapper<>(Zip_Code.class);
        return template.query(sql, rowMapper);
    }

    public List<Vendor> fetchAll(){
        String sql = "SELECT * FROM vendors";
        RowMapper<Vendor> rowMapper = new BeanPropertyRowMapper<>(Vendor.class);
        return template.query(sql, rowMapper);
    }

    public Vendor addVendor(Vendor vendor){
        String sql = "INSERT INTO Vendors (vendor_name, phone, email, address, zip_code_id) " + "VALUES(?, ?, ?, ?, ?)";
        template.update(sql, vendor.getVendor_name(), vendor.getPhone(),vendor.getEmail(),vendor.getAddress(),vendor.getZip_code_id());
        return null;
    }

    public List<Product> fetchProduct(){
        String sql = "SELECT * FROM Products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);
    }

    public Product addProduct(Product product){
        String sql = "INSERT INTO Products (product_description, product_price_per_kg, product_amount) " + "VALUES(?, ?, ?)";
        template.update(sql, product.getProduct_description(), product.getProduct_price_per_kg(), product.getProduct_amount());
        return null;
    }

    public Boolean deleteProduct(int product_id){
        String sql = "DELETE FROM Products WHERE product_id";
        return template.update(sql, product_id) > 0;
    }





    /*
    public List<Person> fetchAll(){
        String sql = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }

    public Person addPerson(Person p){
        String sql = "INSERT INTO person (first_name, last_name) VALUES(?, ?)";
        template.update(sql, p.getFirst_name(), p.getLast_name());
        return null;
    }

    public Person findPersonById(int id){
        String sql = "SELECT * FROM person WHERE id = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person p = template.queryForObject(sql, rowMapper, id);
        return p;
    }

    public Boolean deletePerson(int id){
        String sql = "DELETE FROM person WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public Person updatePerson(int id, Person p){
        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE id = ?";
        template.update(sql, p.getFirst_name(), p.getLast_name(), p.getId());
        return null;
    }
     */
}

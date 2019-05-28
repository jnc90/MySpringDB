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
// this is a method for listing zip codes
    public List<Zip_Code> fetchAllCodes(){
        String sql = "SELECT * FROM Zip_Codes";
        RowMapper<Zip_Code> rowMapper = new BeanPropertyRowMapper<>(Zip_Code.class);
        return template.query(sql, rowMapper);
    }
// this is a method called fetchVendor for listing vendors.
    public List<Vendor> fetchVendor(){
        String sql = "SELECT * FROM Vendors";
        RowMapper<Vendor> rowMapper = new BeanPropertyRowMapper<>(Vendor.class);
        return template.query(sql, rowMapper);
    }
// this is a method for creating and adding a new vendor to the list of vendors
    public Vendor addVendor(Vendor vendor){
        String sql = "INSERT INTO Vendors (vendor_name, phone, email, address, zip_code_id) " + "VALUES(?, ?, ?, ?, ?)";
        template.update(sql, vendor.getVendor_name(), vendor.getPhone(),vendor.getEmail(),vendor.getAddress(),vendor.getZip_code_id());
        return null;
    }

    public Boolean deleteVendor(int vendor_id){
        String sql = "DELETE FROM Vendors WHERE vendor_id = ?";
        return template.update(sql, vendor_id) > 0;
    }

    public Product fetchProduktById(int productId){
        String sql = "SELECT * FROM Products WHERE id = ?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        List<Product> productList = template.query(sql, rowMapper, productId);
        // dos the list exist?
        if(productList == null)
            return null;
        // Is the list empty?
        if(productList.size()==0)
            return null;
        //Now we have a list with one row. We return this row.
        return productList.get(0);
    }


    public Product fetchProductName(String productName){
        String sql = "SELECT * FROM Products WHERE product_description = ?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        //List<Product> productList = template.query(sql, rowMapper, productName);
        List<Product> productList = template.query(sql, rowMapper, productName);
        // dos the list exist?
        if(productList == null)
            return null;
        // Is the list empty?
        if(productList.size()==0)
            return null;
        //Now we have a list with one row. We return this row.
        return productList.get(0);
    }


    public List<Product> fetchProduct(){
        String sql = "SELECT * FROM Products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);
    }

    public Product addProduct(Product newProduct){
        Product candidateProduct = fetchProductName(newProduct.getProduct_description());
        if (candidateProduct == null){
            String sql = "INSERT INTO Products (product_description, product_price_per_kg, product_amount) " + "VALUES(?, ?, ?)";
            template.update(sql, newProduct.getProduct_description(), newProduct.getProduct_price_per_kg(), newProduct.getProduct_amount());
            return null;
        }
        String sql = "UPDATE Products SET product_amount = product_amount + ? WHERE product_description = ?";
        template.update(sql, newProduct.getProduct_amount(),candidateProduct.getProduct_description());
        return null;
    }

    public Boolean deleteProduct(int product_id){
        String sql = "DELETE FROM Products WHERE product_id = ?";
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

package com.example.demo.Repository;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.*;
import java.util.Calendar;

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
// this is a method for creating and adding a new vendor to the table of vendors
    public Vendor addVendor(Vendor vendor){
        String sql = "INSERT INTO Vendors (vendor_name, phone, email, address, zip_code_id) " + "VALUES(?, ?, ?, ?, ?)";
        template.update(sql, vendor.getVendor_name(), vendor.getPhone(),vendor.getEmail(),vendor.getAddress(),vendor.getZip_code_id());
        return null;
    }
// this is a method for deleting a vendor from
    public Boolean deleteVendor(int vendor_id){
        String sql = "DELETE FROM Vendors WHERE vendor_id = ?";
        return template.update(sql, vendor_id) > 0;
    }
// this method is never used. It returns a object from the Product table by ID
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

// this method takes a product name and returns an object from the Products table by the given name
    public Product fetchProductName(String productName){
        String sql = "SELECT * FROM Products WHERE product_description = ?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
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

// this method lists the objects in Products table
    public List<Product> fetchProduct(){
        String sql = "SELECT * FROM Products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);
    }
// this method adds a new product to the Proudcts table. The
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
// this method deletes a product from the Products table. This is done by matching an ID
    public Boolean deleteProduct(int product_id){
        String sql = "DELETE FROM Products WHERE product_id = ?";
        return template.update(sql, product_id) > 0;
    }

    // this is a method for listing orders
    public List<Order> fetchOrder(){
        String sql = "SELECT * FROM orders";
        RowMapper<Order> rowMapper = new BeanPropertyRowMapper<>(Order.class);
        return template.query(sql, rowMapper);
    }

    // add Order
    public Order addOrder(Order order){
        // in the java part of the system we have the attribute "order_date"
        // in the database it is called "order_timestamp"
        String sql = "INSERT INTO Orders (total_price, vendor_id) " + "VALUES(?, ?)";
        template.update(sql, order.getTotal_price(), order.getVendor_id());
        return null;
    }

    // this is a method for listing line_orders
    public List<Line_Order> fetchLine_Order() {
        String sql = "SELECT * FROM line_orders";
        RowMapper<Line_Order> rowMapper = new BeanPropertyRowMapper<>(Line_Order.class);
        return template.query(sql, rowMapper);
    }

    // this is a method for listing line_orders for the current order
    /*
    public List<Line_Order> fetchCurrent_Line_Order(int order_id) {
       // SELECT * FROM permlog ORDER BY id DESC LIMIT 0, 1
        String sql = "SELECT * FROM line_orders ORDER BY order_id DESC LIMIT 0,1";
        RowMapper<Line_Order> rowMapper = new BeanPropertyRowMapper<>(Line_Order.class);
        return template.query(sql, rowMapper);
    }
*/

    // this is a method for creating and adding a new Line_Order to the table of line_orders.
    public Line_Order addLine_Order(Line_Order line_order){
        String sql = "INSERT INTO Line_Orders (order_id, product_id, line_price, line_amount) " + "VALUES(?, ?, ?, ?)";
        template.update(sql, line_order.getOrder_id(), line_order.getProduct_id(),line_order.getLine_price(),line_order.getLine_amount());
        return null;
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

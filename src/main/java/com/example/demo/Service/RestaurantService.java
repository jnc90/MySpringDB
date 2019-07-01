package com.example.demo.Service;

import com.example.demo.Model.*;
import com.example.demo.Repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    public List<Zip_Code> fetchAllCodes(){
        return restaurantRepo.fetchAllCodes();
    }

    public List<Vendor> fetchVendor(){
        return restaurantRepo.fetchVendor();
    }

    public Vendor addVendor(Vendor vendor){
        return restaurantRepo.addVendor(vendor);
    }

    public Boolean deleteVendor(int vendor_id){
        return restaurantRepo.deleteVendor(vendor_id);
    }

    public Product addProduct(Product product){
        return restaurantRepo.addProduct(product);
    }

    public Boolean deleteProduct(int product_id){
        return restaurantRepo.deleteProduct(product_id);
    }

    public List<Product> fetchProduct(){
        return restaurantRepo.fetchProduct();
    }

    public Product fetchProductName(String product_description) {
        return  restaurantRepo.fetchProductName(product_description);
    }

    public List<Order> fetchOrder(){
        return restaurantRepo.fetchOrder();
    }

    public Order addOrder(Order order){
        return restaurantRepo.addOrder(order);
    }

    public List<Line_Order> fetchLine_Order(){
        return restaurantRepo.fetchLine_Order();
    }

   // public List<Line_Order> fetchCurrent_Line_Order(int order_id){return restaurantRepo.fetchCurrent_Line_Order(order_id);}

    public Line_Order addLine_Order(Line_Order line_order){
        return restaurantRepo.addLine_Order(line_order);
    }


    /*
    public List<Person> fetchAll(){
        return restaurantRepo.fetchAll();
    }

    public Person addPerson(Person p){
        return restaurantRepo.addPerson(p);
    }

    public Person findPersonById(int id){
        return restaurantRepo.findPersonById(id);
    }

    public Boolean deletePerson(int id){
        return restaurantRepo.deletePerson(id);
    }

    public Person updatePerson(int id, Person p){
        return restaurantRepo.updatePerson(id, p);
    }
     */
}

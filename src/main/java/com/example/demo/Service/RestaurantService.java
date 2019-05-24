package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.Vendor;
import com.example.demo.Model.Zip_Code;
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

    public List<Vendor> fetchAll(){
        return restaurantRepo.fetchAll();
    }

    public Vendor addVendor(Vendor vendor){
        return restaurantRepo.addVendor(vendor);
    }

    public List<Product> fetchProduct(){
        return restaurantRepo.fetchProduct();
    }

    public Product addProduct(Product product){
        return restaurantRepo.addProduct(product);
    }

    public Boolean deleteProduct(int product_id){
        return restaurantRepo.deleteProduct(product_id);
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

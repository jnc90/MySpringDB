package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

//Controller styrer afviklingen af modellen (URL route, redirect og data indsamling)
//View er HTML filer (HTML, CSS, JavaScript)
//Model er business logic og persistent logic

@Controller
public class HomeController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/")
    public String index(Model model){
        List<Zip_Code> zip_codesList = restaurantService.fetchAllCodes();
        model.addAttribute("zip_codes", zip_codesList);
        return "home/index";
    }

    @GetMapping("/vendors")
    public String vendors(Model model){
        List<Vendor> vendorList = restaurantService.fetchVendor();
        model.addAttribute("Vendors", vendorList);
        return "home/vendors";
    }

    @PostMapping("/vendors")
    public String vendors(@ModelAttribute Vendor vendor){
        restaurantService.addVendor(vendor);
        return "redirect:/vendors";
    }

    @GetMapping("/deleteVendor/{vendor_id}")
    public String deleteVendor(@PathVariable ("vendor_id") int vendor_id){
        boolean deleted = restaurantService.deleteVendor(vendor_id);
        if(deleted){
            return "redirect:/vendors";
        } else{
            return "redirect:/";
        }
    }

    @GetMapping("/product")
    public String products(Model model){
        List<Product> productList = restaurantService.fetchProduct();
        model.addAttribute("Products", productList);
        return "home/product";
    }

    @PostMapping("/product")
    public String products(@ModelAttribute Product product){
        restaurantService.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{product_id}")
    public String deleteProduct(@PathVariable ("product_id") int product_id){
        boolean deleted = restaurantService.deleteProduct(product_id);
        if(deleted){
            return "redirect:/product";
        } else{
            return "redirect:/";
        }
    }

    @GetMapping("/fetchProductName/product_description")
    public String fetchProductName(@PathVariable("product_description") String product_description){
    Product productByName = restaurantService.fetchProductName(product_description);
    return "redirect:/product";
    }

    @PostMapping("/productSearch")
    public String productSearchName(WebRequest wr) {
        String temp = wr.getParameter("product_name");
        restaurantService.fetchProductName(temp);
        return "redirect:home/product";
    }

    @GetMapping("/create_new_order")
    public String orders(Model model){
        List<Order> orderList = restaurantService.fetchOrder();
        model.addAttribute("Orders", orderList);

        //
        List<Order> New_orderList = restaurantService.fetchNewestOrder();
        model.addAttribute("New_Order", New_orderList);

        // line_order ligger under order
        List<Line_Order> line_orderList = restaurantService.fetchLine_Order();
        model.addAttribute("Line_Orders", line_orderList);

        List<Line_Order> new_line_order_list = restaurantService.fetch_new_line_orders();
        model.addAttribute("New_Line_Orders", new_line_order_list);


        return "home/create_new_order";
    }

    @PostMapping("/create_new_order")
    public String create_new_order(@ModelAttribute Order order) {
        restaurantService.addOrder(order);

        return "redirect:/create_new_order";
    }






    // not used?
    @GetMapping("/new_line_order")
    public String new_line_orders(Model model){
        List<Line_Order> new_line_order_list = restaurantService.fetch_new_line_orders();
        model.addAttribute("Line_Orders", new_line_order_list);
        return "home/create_new_order";
    }

    @PostMapping("/new_line_order")
    public String new_line_order (@ModelAttribute Line_Order line_order) {
    restaurantService.addLine_Order(line_order);
        return "redirect:/create_new_order";
    }


    @GetMapping("/dishes")
    public String dishes(){
        return "home/dishes";
    }

    @GetMapping("/inventory")
    public String inventory(){
        return "home/inventory";
    }


     @GetMapping("/balance")
    public String balance(){
        return "home/balance";
    }

}

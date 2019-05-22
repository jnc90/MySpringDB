package com.example.demo.Controller;

import com.example.demo.Model.Person;
import com.example.demo.Model.Zip_Code;
import com.example.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


    @GetMapping("/create_new_order")
    public String create_new_order(){
        return "home/create_new_order";
    }

    @GetMapping("/dishes")
    public String dishes(){
        return "home/dishes";
    }

    @GetMapping("/inventory")
    public String inventory(){
        return "home/inventory";
    }

    @GetMapping("/vendors")
    public String vendors(){
        return "home/vendors";
    }

    @GetMapping("/product")
    public String product(){
        return "home/product";
    }

     @GetMapping("/balance")
    public String balance(){
        return "home/balance";
    }

/* gammelt start
    @GetMapping("/create")
    public String create(){
        return "home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Person person){
        personService.addPerson(person);
        return "redirect:/";
    }

    @GetMapping("/viewOne/{id}")
    public String viewOne(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.findPersonById(id));
        return "home/viewOne";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        boolean deleted = personService.deletePerson(id);
        if(deleted){
            return "redirect:/";
        } else{
            return "redirect:/";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.findPersonById(id));
        return "home/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Person person){
        personService.updatePerson(person.getId(), person);
        return "redirect:/";
    }
    gammelt slut */
}

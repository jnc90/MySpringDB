package com.example.demo.Controller;

import com.example.demo.Model.Person;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//Controller styrer afviklingen af modellen
@Controller
public class HomeController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String index(Model model){
        List<Person> personList = personService.fetchAll();
        model.addAttribute("persons", personList);
        return "home/index";
    }
    // testing start

    @GetMapping("/create_new_order")
    public String create_new_order(){
        return "home/create_new_order";
    }
    @GetMapping("/index")
    public String index(){
        return "home/index";
    }
     //testing end
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
}

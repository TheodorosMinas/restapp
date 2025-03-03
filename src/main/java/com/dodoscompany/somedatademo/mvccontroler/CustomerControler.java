package com.dodoscompany.somedatademo.mvccontroler;

import com.dodoscompany.somedatademo.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerControler {

    @GetMapping("/customerLogin")
    public String customerLogin(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "customerLogForm";
    }

    @PostMapping("/customerWelcome")
    public String customerWelcome(@ModelAttribute("customer") Customer customer){
        System.out.println("customer :"+ customer);
        return "customerWelcome";
    }

}

package com.dodoscompany.somedatademo.mvccontroler;

import com.dodoscompany.somedatademo.models.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerControler {

    @Value("${countries}")
    List<String > countries;
    @Value("${programmingLanguages}")
    List<String> plangs;

    @Value("${operatingSystems}")
    List<String> operatingSystems;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/customerLogin")
    public String customerLogin(Model model){
        Customer customer=new Customer();
        model.addAttribute("customer",customer);
//        List<String> countries = Arrays.asList("USA", "Canada", "Mexico");
        model.addAttribute("countries", countries);
        model.addAttribute("plangs",plangs);
        model.addAttribute("operatingSystems",operatingSystems);
        return "customerLogForm";
    }

    @PostMapping("/customerWelcome")
    public String customerWelcome(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        System.out.println("i am here");
        if (bindingResult.hasErrors()) {
            model.addAttribute("countries", countries);
            model.addAttribute("plangs", plangs);
            model.addAttribute("operatingSystems", operatingSystems);
            return "customerLogForm";
        }
        System.out.println("customer :"+ customer);
        return "customerWelcome";
    }

}

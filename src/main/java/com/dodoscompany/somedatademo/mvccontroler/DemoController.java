package com.dodoscompany.somedatademo.mvccontroler;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String someForm(HttpServletRequest request, Model model){

        return "hello";
    }

//    @RequestMapping("/processForm")
//    public String uppCaseForm(HttpServletRequest request, Model model){
//        String name=request.getParameter("name");
//        name=name.toUpperCase();
//        model.addAttribute("message",name);
//        return "form";
//    }

    @PostMapping("/processForm")
    public String uppCaseForm(@RequestParam("name") String theName, Model model){
        String name=theName.concat(" roufas gavlia").toUpperCase();
        model.addAttribute("message",name);
        return "form";
    }

}

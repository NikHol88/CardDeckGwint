package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SpringBootController {
    @GetMapping("/123")
    public String sayHello(@RequestParam(value = "name",required=false)  String name,
                           @RequestParam(value="frakt",required = false) String surname){

        System.out.println("hello   "+ name+"  "+surname);
        return "index";
    }
    @PostMapping("/setname")
    public void calc(@RequestBody MultiValueMap<String, String> formData){
System.out.println(formData);

    }

/*   @PostMapping("/calc")
    public String getVaules(@G){
        String text = ("/calc.html");
        return text;
   }*/
}

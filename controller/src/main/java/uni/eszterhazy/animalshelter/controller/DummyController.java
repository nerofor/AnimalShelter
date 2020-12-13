package uni.eszterhazy.animalshelter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DummyController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Hello!");
        return "hello.jsp";
    }
}

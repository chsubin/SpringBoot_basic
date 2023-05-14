package hello.hellospring.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello"; //hello.html로 보냄
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name",required = false)String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}

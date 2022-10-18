package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // "/" 의 의미: http로 들어가게 되면 가장 먼저 index.html이 아닌 home이 호출되는 코드
    public String home(){ // hello.html이 무시되는 것임
        return "home";
    }
}

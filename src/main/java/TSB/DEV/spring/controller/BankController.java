package TSB.DEV.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

    @GetMapping("/")
    public String bankApplication() {
        return "index";
    }
    
    @GetMapping("/done")
    public String sucessOperation() {
        return "sucess";
    }
    
}

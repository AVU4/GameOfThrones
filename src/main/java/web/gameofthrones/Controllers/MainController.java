package web.gameofthrones.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Controller
public class MainController {

    @GetMapping("/")
    public String get(){
        return "/index.html";
    }
}

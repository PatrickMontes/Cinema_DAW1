package pe.edu.cibertec.proyectodaw1.controller.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "backoffice/inicio/index";
    }

    @GetMapping("/cinerama")
    public String cinerama(){return "backoffice/inicio/cinerama";}

}

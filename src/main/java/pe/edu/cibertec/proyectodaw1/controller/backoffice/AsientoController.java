package pe.edu.cibertec.proyectodaw1.controller.backoffice;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectodaw1.model.bd.Asiento;
import pe.edu.cibertec.proyectodaw1.service.IAsientoService;

import java.util.List;

@Controller
@RequestMapping("/backoffice")
public class AsientoController {

    @Autowired
    private IAsientoService asientoService;

    //localhost:8080/backoffice/listarAsientos
    @GetMapping("/listarAsientos")
    public String listarAsientos(Model model) {
        List<Asiento> asientos = asientoService.listarAsientos();
        model.addAttribute("asientos", asientos);
        return "backoffice/asientos/formAsientos";
    }
}

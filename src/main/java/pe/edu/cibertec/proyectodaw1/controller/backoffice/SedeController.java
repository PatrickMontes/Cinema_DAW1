package pe.edu.cibertec.proyectodaw1.controller.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.proyectodaw1.model.bd.Sede;
import pe.edu.cibertec.proyectodaw1.service.ISedeService;

import java.util.List;

@Controller
public class SedeController {

    @Autowired
    private ISedeService sedeService;

    @GetMapping("/listarSedes")
    public String listarSedes(Model model) {
        List<Sede> sedes = sedeService.listarSedes();
        model.addAttribute("sedes", sedes);
        return "backoffice/sede/formSedes";
    }
}

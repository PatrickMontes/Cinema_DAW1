package pe.edu.cibertec.proyectodaw1.controller.backoffice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.cibertec.proyectodaw1.model.bd.Sede;
import pe.edu.cibertec.proyectodaw1.model.dto.request.SedeRequest;
import pe.edu.cibertec.proyectodaw1.service.ISedeService;

import java.util.List;

@Controller
public class SedeController {

    @Autowired
    private ISedeService sedeService;

    //localhost:8080/listarSedes
    @GetMapping("/listarSedes")
    public String listarSedes(Model model) {
        List<Sede> sedes = sedeService.listarSedes();
        model.addAttribute("sedes", sedes);
        return "backoffice/sede/formSedes";
    }

    @PostMapping("/guardarSede")
    public String guardarSede(@ModelAttribute SedeRequest sedeRequest) {
        Sede sede = new Sede();
        sede.setNombre(sedeRequest.getNombre());
        sede.setUbicacion(sedeRequest.getUbicacion());

        sedeService.guardarSede(sede);

        return "redirect:/listarSedes";
    }

    @PostMapping("/actualizarSede")
    public String actualizarSede(@ModelAttribute Sede sede) {
        sedeService.actualizarSede(sede);
        return "redirect:/listarSedes";
    }

    @PostMapping("/eliminarSede")
    public String eliminarSede(@RequestParam("sede_id") int sedeId) {
        sedeService.eliminarSede(sedeId);
        return "redirect:/listarSedes";
    }
}




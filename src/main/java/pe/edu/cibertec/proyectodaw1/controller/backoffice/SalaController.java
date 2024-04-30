package pe.edu.cibertec.proyectodaw1.controller.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectodaw1.model.bd.Sala;
import pe.edu.cibertec.proyectodaw1.model.bd.Sede;
import pe.edu.cibertec.proyectodaw1.model.dto.request.SalaRequest;
import pe.edu.cibertec.proyectodaw1.service.ISalaService;
import pe.edu.cibertec.proyectodaw1.service.ISedeService;

import java.util.List;

@Controller
public class SalaController {

    @Autowired
    private ISalaService salaService;

    @Autowired
    private ISedeService sedeService;

    @GetMapping("/listarSalas")
    public String listarSalas(Model model) {
        List<Sala> salas = salaService.listarSalas();
        model.addAttribute("salas", salas);
        return "backoffice/sala/formSalas";
    }

    @PostMapping("/guardarSala")
    public String guardarSala(@ModelAttribute SalaRequest salaRequest) {
        Sala sala = new Sala();
        sala.setNombre(salaRequest.getNombre());

        // Aquí asumo que en SalaRequest tienes el ID de la sede al que pertenece la sala
        Sede sede = sedeService.obtenerSedePorId(salaRequest.getSedeId());
        sala.setSede(sede);

        salaService.guardarSala(sala);

        return "redirect:/listarSalas";
    }

    @PostMapping("/eliminarSala")
    public String eliminarSala(@RequestParam("id") Integer id) {
        salaService.eliminarSalaPorId(id);
        return "redirect:/listarSalas";
    }


    @ModelAttribute("sedes")
    public List<Sede> listarSedes() {
        return sedeService.listarSedes();
    }
}

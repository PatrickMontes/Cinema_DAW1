package pe.edu.cibertec.proyectodaw1.controller.frontoffice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.proyectodaw1.service.IPeliculaService;

@Controller
@RequestMapping("/cinerama")
public class CineramaController {
    @Autowired
    private IPeliculaService iPeliculaService;

    @GetMapping("/principal")
    public String paginaPrincipal(Model model){
        model.addAttribute("peliculas", iPeliculaService.listTop(5));
        return "backoffice/principal/CineramaPrincipal";
    }

    @GetMapping("/cartelera")
    public String cartelera(Model model){
        model.addAttribute("peliculas",iPeliculaService.listarPeliculas());
        return "backoffice/principal/cartelera";
    }
}

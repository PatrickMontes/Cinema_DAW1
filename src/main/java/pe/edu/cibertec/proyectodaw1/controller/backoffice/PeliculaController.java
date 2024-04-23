package pe.edu.cibertec.proyectodaw1.controller.backoffice;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.proyectodaw1.model.bd.Pelicula;
import pe.edu.cibertec.proyectodaw1.service.IPeliculaService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping("/pelicula")
public class PeliculaController {
    @Autowired
    private IPeliculaService iPeliculaService;

    @GetMapping("/listar")
    public String formpelicula(Model model){
        model.addAttribute("peliculas", iPeliculaService.listarPeliculas());
        return "backoffice/pelicula/formpelicula";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, Model model,
                          @RequestParam("file") MultipartFile imagen, RedirectAttributes attribute) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario Nueva Pelicula");
            model.addAttribute("pelicula", pelicula);
            attribute.addFlashAttribute("warning", "Existieron errores en el formulario");
            return "backoffice/pelicula/formpelicula";
        }

        if (!imagen.isEmpty()) {
            Path directorioImagenes = Paths.get("src/main/resources/static/imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "/" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                pelicula.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                attribute.addFlashAttribute("error", "Hubo un error al procesar la imagen.");
                return "redirect:/pelicula/listar";
            }
        }

        try {
            iPeliculaService.guardarPelicula(pelicula);
            attribute.addFlashAttribute("mensaje", "La película se guardó correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            attribute.addFlashAttribute("error", "Hubo un error al guardar la película.");
        }

        return "redirect:/pelicula/listar";
    }
    @GetMapping("/get")
    @ResponseBody
    public List<Pelicula> listarPeliculas(){
        return iPeliculaService.listarPeliculas();
    }
}

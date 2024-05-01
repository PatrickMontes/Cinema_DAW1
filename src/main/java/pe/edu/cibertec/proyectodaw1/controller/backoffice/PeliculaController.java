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
import java.util.Optional;


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


    @GetMapping("/pelicula_Register")
    public String formregisterPelicula(Model model){
        model.addAttribute("pelicula", new Pelicula());
        return "backoffice/pelicula/formRegisterPelicula";
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
    @GetMapping("/editar/{id}")
    public String formEditarPelicula(@PathVariable Integer id, Model model){
        Pelicula pelicula = iPeliculaService.buscarPeliculaPorId(id);
        if (pelicula != null) {
            model.addAttribute("pelicula", pelicula);
            return "backoffice/pelicula/formeditarpelicula";
        } else {
            // Manejar el caso donde la película no existe
            return "redirect:/pelicula/listar"; // O mostrar un mensaje de error, etc.
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPelicula(@PathVariable Integer id, @ModelAttribute("pelicula") Pelicula pelicula, RedirectAttributes attribute) {
        Pelicula peliculaExistente = iPeliculaService.buscarPeliculaPorId(id);
        peliculaExistente.setTitulo(pelicula.getTitulo());
        peliculaExistente.setGenero(pelicula.getGenero());
        peliculaExistente.setDuracion(pelicula.getDuracion());
        peliculaExistente.setImagen(pelicula.getImagen());

        iPeliculaService.guardarPelicula(peliculaExistente);
        // Redirigir al usuario a la lista de películas
        return "redirect:/pelicula/listar";
    }
    @GetMapping("/peliculas/{id}")
    public String eliminarPelicula(@PathVariable Integer id){
        iPeliculaService.eliminarPelicula(id);
        return "redirect:/pelicula/listar";
    }
    @GetMapping("/get")
    @ResponseBody
    public List<Pelicula> listarPeliculas(){
        return iPeliculaService.listarPeliculas();
    }
}
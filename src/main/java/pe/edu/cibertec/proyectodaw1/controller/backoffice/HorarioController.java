package pe.edu.cibertec.crudhorarios.Controlador;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.crudhorarios.Entidad.Horario;
import pe.edu.cibertec.crudhorarios.Entidad.Pelicula;
import pe.edu.cibertec.crudhorarios.Entidad.Sala;
import pe.edu.cibertec.crudhorarios.Entidad.Sede;
import pe.edu.cibertec.crudhorarios.Service.HorarioService;
import pe.edu.cibertec.crudhorarios.Service.PeliculaService;
import pe.edu.cibertec.crudhorarios.Service.SalaService;
import pe.edu.cibertec.crudhorarios.Service.SedeService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class HorarioController {

    private SedeService sedeService;
    private SalaService salaService;
    private PeliculaService peliculaService;
    private HorarioService horarioService;

    @RequestMapping("/")
    public String verCrud(){
        return "horarios";
    }

    @RequestMapping("/cargaSede")
    @ResponseBody
    public List<Sede> listaSede(){
        return sedeService.listaSede();
    }

    @RequestMapping("/cargaHorarios")
    @ResponseBody
    public List<Horario> listaHorarios(){
        return horarioService.listaTodos();
    }


    @RequestMapping("/cargaSala")
    @ResponseBody
    public List<Sala> listaSala(){
        return salaService.listaSala();
    }


    @RequestMapping("/cargaPelicula")
    @ResponseBody
    public List<Pelicula> listaPelicula(){
        return peliculaService.listaPelicula();
    }


    @RequestMapping("/consultaCrudHorarios")
    public String consulta(Date filtro, HttpSession session){
        List<Horario> lista = horarioService.listaPorHorario(filtro);
        session.setAttribute("horarios", lista);
        return "horarios";
    }


    @RequestMapping("/registraActualizaCrudHorarios")
    public String insertaActualiza(Horario horario, HttpSession session){
        try {
            Horario obj = horarioService.insertaActualizaHorario(horario);
            if(obj == null){
                session.setAttribute("MENSAJE", "Error insertar o actualizar");
            }else {
                session.setAttribute("MENSAJE", "Se inserto y actualizo el horario");
            }
        }catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("MENSAJE", "Error al insertar o actualizar el Horario");
        }
        return "redirect:/salidaHorario";
    }


    @RequestMapping("/eliminaCrudHorarios")
    public String elimina(String id, HttpSession session){
        try {
            Optional<Horario> obj = horarioService.buscaPorId(Integer.parseInt(id));
            if(obj.isPresent()){
                horarioService.eliminaHorario(Integer.parseInt(id));
                session.setAttribute("MENSAJE", "Se eliminado el Horario");
            }else {
                session.setAttribute("MENSAJE", "No se encontro el Horario");
            }
        }catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("MENSAJE", "Error al eliminar el Horario");
        }
        return "redirect:/salidaHorario";
    }


    @RequestMapping("/salidaHorarios")
    public String salida(HttpSession session){
        List<Horario> lista = horarioService.listaTodos();
        session.setAttribute("horarios", lista);
        return "horarios";
    }
}

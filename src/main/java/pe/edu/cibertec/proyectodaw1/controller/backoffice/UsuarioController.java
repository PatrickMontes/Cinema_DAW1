package pe.edu.cibertec.proyectodaw1.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.cibertec.proyectodaw1.model.bd.Pelicula;
import pe.edu.cibertec.proyectodaw1.model.bd.Usuario;
import pe.edu.cibertec.proyectodaw1.model.dto.request.UsuarioRequest;
import pe.edu.cibertec.proyectodaw1.service.IUsuarioService;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService iUsuarioService;
    @GetMapping("/frmRegister")
    public String frmRegister(Model model ){
        model.addAttribute("usuarioRequest",new UsuarioRequest());
        return "backoffice/auth/frmRegister";
    }

    @GetMapping("/listaUsuarios")
    public String frmListarUsuarios(Model model){
        model.addAttribute("usuarios",iUsuarioService.listarUsuarios());
        return "backoffice/auth/frmUsuarios";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute("usuarioRequest") UsuarioRequest usuarioRequest){

        Usuario usuario = new Usuario();

        usuario.setNomusuario(usuarioRequest.getNomusuario());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setNombres(usuarioRequest.getNombres());
        usuario.setApellidos(usuarioRequest.getApellidos());
        iUsuarioService.guardarUsuario(usuario,"Usuario");

        return "redirect:/listaUsuarios";
    }


}

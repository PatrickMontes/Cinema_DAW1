package pe.edu.cibertec.proyectodaw1.controller.backoffice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.proyectodaw1.model.dto.security.UsuarioSecurity;
import pe.edu.cibertec.proyectodaw1.service.IUsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {
    private IUsuarioService iUsuarioService;
    @GetMapping("/login")
    public String login(){
        return "backoffice/auth/frmlogin";
    }
    @GetMapping("/login-success")
    public String loginSuccess(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        UsuarioSecurity usuarioSecurity = (UsuarioSecurity) userDetails;
        session.setAttribute("nomusuario", usuarioSecurity.getNombre());
        session.setAttribute("nomrol",usuarioSecurity.getAuthorities());
        return "redirect:/inicio/index";
    }
    @GetMapping("/dashboard")
    public String dashboard(){

        return "redirect:/inicio/index";
    }
}

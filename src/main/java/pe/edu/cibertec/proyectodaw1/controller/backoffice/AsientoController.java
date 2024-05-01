package pe.edu.cibertec.proyectodaw1.controller.backoffice;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.proyectodaw1.model.bd.Asiento;
import pe.edu.cibertec.proyectodaw1.service.IAsientoService;

import java.util.List;

@Controller
public class AsientoController {

    @Autowired
    private IAsientoService asientoService;
}


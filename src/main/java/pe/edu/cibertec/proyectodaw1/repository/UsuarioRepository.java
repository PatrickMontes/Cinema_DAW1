package pe.edu.cibertec.proyectodaw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectodaw1.model.bd.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario , Integer> {
    Usuario findByNomusuario(String nomusuario);
}

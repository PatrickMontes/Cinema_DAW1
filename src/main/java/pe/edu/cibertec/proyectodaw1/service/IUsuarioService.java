package pe.edu.cibertec.proyectodaw1.service;

import pe.edu.cibertec.proyectodaw1.model.bd.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario findUserByNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario , String nomrol);

    List<Usuario> listarUsuarios();
    Usuario obtenerUsuarioxId(int id);
    void actualizarUsuario(Usuario usuario);
}

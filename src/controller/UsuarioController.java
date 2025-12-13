package controller;

import model.dao.UsuarioDAO;
import model.entities.Usuario;

public class UsuarioController {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario autenticarUsuario(String idUsuario, String clave) {
        return usuarioDAO.login(idUsuario, clave);
    }

    public Usuario obtenerPorId(String idUsuario) {
        return usuarioDAO.obtenerUsuarioPorId(idUsuario);
    }

}

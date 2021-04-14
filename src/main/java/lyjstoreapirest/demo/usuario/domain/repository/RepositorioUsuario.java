package lyjstoreapirest.demo.usuario.domain.repository;

import lyjstoreapirest.demo.usuario.domain.model.Usuario;

import java.util.Optional;

public interface RepositorioUsuario {
    public String guardarUsuario(Usuario usuario);

    public Optional<Usuario> buscarUsuarioPorId(String idUsuario);
}

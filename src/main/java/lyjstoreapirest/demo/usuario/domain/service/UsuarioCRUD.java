package lyjstoreapirest.demo.usuario.domain.service;

import lyjstoreapirest.demo.usuario.domain.dto.UsuarioDTO;

import java.util.Optional;

public interface UsuarioCRUD {
    public String guardarUsuario(UsuarioDTO usuarioDTO);
}

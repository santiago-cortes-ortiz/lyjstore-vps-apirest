package lyjstoreapirest.demo.usuario.domain.service;

import lyjstoreapirest.demo.usuario.domain.dto.UsuarioDTO;

import java.util.Optional;

public interface UsuarioCRUD {
    String guardarUsuario(UsuarioDTO usuarioDTO);
    Optional<UsuarioDTO> buscarUsuarioPorId(String idUsuario);

}

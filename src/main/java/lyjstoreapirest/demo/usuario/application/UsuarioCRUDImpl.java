package lyjstoreapirest.demo.usuario.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Servicio;
import lyjstoreapirest.demo.usuario.domain.dto.UsuarioDTO;
import lyjstoreapirest.demo.usuario.domain.repository.RepositorioUsuario;
import lyjstoreapirest.demo.usuario.domain.service.UsuarioCRUD;
import lyjstoreapirest.demo.usuario.infraestructure.mapper.UsuarioMapper;

@Servicio
@AllArgsConstructor
public class UsuarioCRUDImpl implements UsuarioCRUD {

    private final RepositorioUsuario repositorioUsuario;

    private final UsuarioMapper usuarioMapper;

    @Override
    public String guardarUsuario(UsuarioDTO usuarioDTO) {
        String idUsuario = repositorioUsuario.guardarUsuario(usuarioMapper.usuarioDtoToUsuario(usuarioDTO));
        return idUsuario;
    }
}

package lyjstoreapirest.demo.usuario.infraestructure.mapper;

import lyjstoreapirest.demo.usuario.domain.dto.UsuarioDTO;
import lyjstoreapirest.demo.usuario.domain.model.Usuario;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper
public interface UsuarioMapper {

    public Usuario usuarioDtoToUsuario(UsuarioDTO usuarioDTO);
    public UsuarioDTO usuarioToUsuarioDto(Usuario usuario);

}

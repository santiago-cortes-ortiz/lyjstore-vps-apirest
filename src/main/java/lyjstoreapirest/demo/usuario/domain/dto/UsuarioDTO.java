package lyjstoreapirest.demo.usuario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private String usuario;

    private String contrasenia;

    private Long idRol;

    private Long idEmpleado;
}

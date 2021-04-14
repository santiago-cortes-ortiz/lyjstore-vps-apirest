package lyjstoreapirest.demo.usuario.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Repositorio;
import lyjstoreapirest.demo.usuario.domain.model.Usuario;
import lyjstoreapirest.demo.usuario.domain.repository.JpaUsuario;
import lyjstoreapirest.demo.usuario.domain.repository.RepositorioUsuario;

import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RepositorioUsuarioImpl implements RepositorioUsuario {
    private final JpaUsuario jpaUsuario;
    @Override
    public String guardarUsuario(Usuario usuario) {
        return jpaUsuario.save(usuario).getUsuario();
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(String idUsuario) {
        return jpaUsuario.findById(idUsuario);
    }
}

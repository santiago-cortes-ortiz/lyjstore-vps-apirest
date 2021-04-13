package lyjstoreapirest.demo.rol.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Repositorio;
import lyjstoreapirest.demo.rol.domain.model.Rol;
import lyjstoreapirest.demo.rol.domain.repository.JpaRol;
import lyjstoreapirest.demo.rol.domain.repository.RepositorioRol;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RepositorioRolImpl implements RepositorioRol
{

    private JpaRol jpaRol;

    @Override
    public Long guardar(Rol rol)
    {
        return jpaRol.save(rol).getIdRol();
    }

    @Override
    public Optional<Rol> buscarRolPorId(Long idRol)
    {
        return jpaRol.findById(idRol);
    }

    @Override
    public Optional<Rol> eliminarRolPorId(Long idRol) {
        jpaRol.deleteById(idRol);
        return Optional.empty();
    }

    @Override
    public List<Rol> listarRoles() {
        return jpaRol.findAll();
    }
}

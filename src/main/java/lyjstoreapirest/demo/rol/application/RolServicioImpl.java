package lyjstoreapirest.demo.rol.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.rol.domain.service.RolServicio;
import lyjstoreapirest.demo.rol.domain.model.Rol;
import lyjstoreapirest.demo.rol.domain.repository.RepositorioRol;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class RolServicioImpl implements RolServicio {

    private RepositorioRol repositorioRol;

    @Override
    public Long guardar(Rol rol) {
        return repositorioRol.guardar(rol);
    }

    @Override
    public Optional<Rol> buscarRolPorId(Long idRol)
    {
        return repositorioRol.buscarRolPorId(idRol);
    }

    @Override
    public Optional<Rol> eliminarRolPorId(Long idRol) {
        repositorioRol.eliminarRolPorId(idRol);
        return Optional.empty();
    }

    @Override
    public List<Rol> listarRoles()
    {
        return repositorioRol.listarRoles();
    }
}

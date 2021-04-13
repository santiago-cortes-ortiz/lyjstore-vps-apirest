package lyjstoreapirest.demo.rol.domain.repository;

import lyjstoreapirest.demo.rol.domain.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioRol
{

    Long guardar(Rol rol);

    Optional<Rol> buscarRolPorId(Long idRol);

    Optional<Rol> eliminarRolPorId(Long idRol);

    List<Rol> listarRoles();




}

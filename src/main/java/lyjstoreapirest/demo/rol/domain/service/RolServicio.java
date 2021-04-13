package lyjstoreapirest.demo.rol.domain.service;

import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.rol.domain.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolServicio
{

    Long guardar(Rol rol);

    Optional<Rol> buscarRolPorId(Long idRol);

    Optional<Rol> eliminarRolPorId(Long idRol);

    List<Rol> listarRoles();
}

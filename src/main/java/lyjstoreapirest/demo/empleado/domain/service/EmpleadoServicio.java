package lyjstoreapirest.demo.empleado.domain.service;

import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import lyjstoreapirest.demo.empleado.domain.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoServicio {
    Long guardar(Empleado empleado);

    Optional<Empleado> buscarEmpleadoPorId(Long idEmpleado);

    Optional<Empleado> eliminarEmpleadoPorId(Long idEmpleado);

    List<Empleado> listarEmpleado();
}

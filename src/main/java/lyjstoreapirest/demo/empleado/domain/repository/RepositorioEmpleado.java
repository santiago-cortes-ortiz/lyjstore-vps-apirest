package lyjstoreapirest.demo.empleado.domain.repository;

import lyjstoreapirest.demo.empleado.domain.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface RepositorioEmpleado  {

    Long guardar(Empleado empleado);

    Optional<Empleado> buscarEmpleadoPorId(Long idEmpleado);

    Optional<Empleado> eliminarEmpleadoPorId(Long idEmpleado);

    List<Empleado> listarEmpleado();

}

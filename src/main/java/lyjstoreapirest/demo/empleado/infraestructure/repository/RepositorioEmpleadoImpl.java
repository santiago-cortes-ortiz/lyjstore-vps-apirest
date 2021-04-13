package lyjstoreapirest.demo.empleado.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.empleado.domain.model.Empleado;
import lyjstoreapirest.demo.empleado.domain.repository.JpaMetodosEmpleado;
import lyjstoreapirest.demo.empleado.domain.repository.RepositorioEmpleado;
import lyjstoreapirest.demo.general_service.Repositorio;

import java.util.List;
import java.util.Optional;


@Repositorio
@AllArgsConstructor
public class RepositorioEmpleadoImpl implements RepositorioEmpleado {

    private JpaMetodosEmpleado jpaMetodosEmpleado;

    @Override
    public Long guardar(Empleado empleado) {
        return jpaMetodosEmpleado.save(empleado).getCedula();
    }

    @Override
    public Optional<Empleado> buscarEmpleadoPorId(Long idEmpleado) {
        return jpaMetodosEmpleado.findById(idEmpleado);
    }

    @Override
    public Optional<Empleado> eliminarEmpleadoPorId(Long idEmpleado) {
        jpaMetodosEmpleado.deleteById(idEmpleado);
        return Optional.empty();
    }

    @Override
    public List<Empleado> listarEmpleado() {
        return jpaMetodosEmpleado.findAll();
    }
}

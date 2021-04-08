package lyjstoreapirest.demo.empleado.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.empleado.domain.model.Empleado;
import lyjstoreapirest.demo.empleado.domain.repository.RepositorioEmpleado;
import lyjstoreapirest.demo.empleado.domain.service.EmpleadoServicio;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class EmpleadoServicioImpl implements EmpleadoServicio {

    private RepositorioEmpleado repositorioEmpleado;

    @Override
    public Long guardar(Empleado empleado) {
        return repositorioEmpleado.save(empleado).getCedula();
    }

    @Override
    public Optional<Empleado> buscarEmpleadoPorId(Long idEmpleado) {
        return repositorioEmpleado.findById(idEmpleado);
    }

    @Override
    public Optional<Empleado> eliminarEmpleadoPorId(Long idEmpleado) {
        repositorioEmpleado.deleteById(idEmpleado);
        return Optional.empty();
    }

    @Override
    public List<Empleado> listarEmpleado() {
        return repositorioEmpleado.findAll();
    }
}

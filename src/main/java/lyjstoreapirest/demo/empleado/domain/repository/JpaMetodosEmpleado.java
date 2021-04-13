package lyjstoreapirest.demo.empleado.domain.repository;

import lyjstoreapirest.demo.empleado.domain.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMetodosEmpleado extends JpaRepository<Empleado, Long> {
}

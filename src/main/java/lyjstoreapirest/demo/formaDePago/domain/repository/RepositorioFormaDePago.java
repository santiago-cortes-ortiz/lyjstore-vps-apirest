package lyjstoreapirest.demo.formaDePago.domain.repository;

import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioFormaDePago extends JpaRepository<FormaDePago,Long> {
}

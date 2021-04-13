package lyjstoreapirest.demo.tiposDeCuenta.domain.repository;

import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMetodosTiposDeCuenta extends JpaRepository<TipoDeCuenta, Long> {
}

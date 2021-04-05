package lyjstoreapirest.demo.cuentaAmazon.domain.repository;

import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCuentaAmazon extends JpaRepository<CuentaAmazon,Long> {
}

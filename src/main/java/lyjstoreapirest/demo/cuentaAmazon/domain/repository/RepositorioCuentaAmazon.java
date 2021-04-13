package lyjstoreapirest.demo.cuentaAmazon.domain.repository;

import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioCuentaAmazon {

    Long guardar(CuentaAmazon cuentaAmazon);

    Optional<CuentaAmazon> buscarCuentaAmazonPorId(Long idCuentaAmazon);

    Optional<CuentaAmazon> eliminarCuentaAmazonPorId(Long idCuentaAmazon);

    List<CuentaAmazon> listarCuentasAmazon();
}

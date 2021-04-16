package lyjstoreapirest.demo.cuentaAmazon.domain.repository;

import lyjstoreapirest.demo.cuentaAmazon.domain.dto.CuentaAmazonDTO;
import lyjstoreapirest.demo.cuentaAmazon.infraestructure.entity.CuentaAmazon;

import java.util.List;
import java.util.Optional;

public interface RepositorioCuentaAmazon {

    Long guardar(CuentaAmazonDTO cuentaAmazon);

    CuentaAmazonDTO buscarCuentaAmazonPorId(Long idCuentaAmazon);

    Optional<CuentaAmazonDTO> eliminarCuentaAmazonPorId(Long idCuentaAmazon);

    List<CuentaAmazonDTO> listarCuentasAmazon();
}

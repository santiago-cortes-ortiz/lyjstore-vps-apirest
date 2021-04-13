package lyjstoreapirest.demo.cuentaAzure.domain.repository;

import lyjstoreapirest.demo.cuentaAzure.domain.model.CuentaAzure;

import java.util.List;
import java.util.Optional;

public interface RepositorioCuentaAzure {

    Long guardar(CuentaAzure cuentaAzure);

    Optional<CuentaAzure> buscarCuentaAzurePorId(Long idCuentaAzure);

    Optional<CuentaAzure> eliminarCuentaAzurePorId(Long idCuentaAzure);

    List<CuentaAzure> listarCuentasAzure();


}

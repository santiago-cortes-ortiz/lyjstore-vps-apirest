package lyjstoreapirest.demo.cuentaAzure.domain.service;


import lyjstoreapirest.demo.cuentaAzure.domain.model.CuentaAzure;

import java.util.List;
import java.util.Optional;

public interface CuentaAzureServicio
{
    Long guardar(CuentaAzure cuentaAzure);

    Optional<CuentaAzure> buscarCuentaAzurePorId(Long idCuentaAzure);

    Optional<CuentaAzure> eliminarCuentaAzurePorId(Long idCuentaAzure);

    List<CuentaAzure> listarCuentasAzure();
}

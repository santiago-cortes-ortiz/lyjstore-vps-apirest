package lyjstoreapirest.demo.cuentaAzure.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAzure.domain.service.CuentaAzureServicio;
import lyjstoreapirest.demo.cuentaAzure.domain.model.CuentaAzure;
import lyjstoreapirest.demo.cuentaAzure.domain.repository.RepositorioCuentaAzure;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class CuentaAzureServicioImpl implements CuentaAzureServicio {

    private RepositorioCuentaAzure repositorioCuentaAzure;

    @Override
    public Long guardar(CuentaAzure cuentaAzure) {
        return repositorioCuentaAzure.guardar(cuentaAzure);
    }

    @Override
    public Optional<CuentaAzure> buscarCuentaAzurePorId(Long idCuentaAzure) {
        return repositorioCuentaAzure.buscarCuentaAzurePorId(idCuentaAzure);
    }

    @Override
    public Optional<CuentaAzure> eliminarCuentaAzurePorId(Long idCuentaAzure) {
        repositorioCuentaAzure.eliminarCuentaAzurePorId(idCuentaAzure);
        return Optional.empty();
    }

    @Override
    public List<CuentaAzure> listarCuentasAzure() {
        return repositorioCuentaAzure.listarCuentasAzure();
    }
}

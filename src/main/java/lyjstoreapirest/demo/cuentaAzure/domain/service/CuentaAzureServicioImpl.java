package lyjstoreapirest.demo.cuentaAzure.domain.service;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAzure.application.CuentaAzureServicio;
import lyjstoreapirest.demo.cuentaAzure.domain.model.CuentaAzure;
import lyjstoreapirest.demo.cuentaAzure.domain.repository.RepositorioCuentaAzure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CuentaAzureServicioImpl implements CuentaAzureServicio {

    private RepositorioCuentaAzure repositorioCuentaAzure;

    @Override
    public Long guardar(CuentaAzure cuentaAzure) {
        return repositorioCuentaAzure.save(cuentaAzure).getIdCuentaAzure();
    }

    @Override
    public Optional<CuentaAzure> buscarCuentaAzurePorId(Long idCuentaAzure) {
        return repositorioCuentaAzure.findById(idCuentaAzure);
    }

    @Override
    public Optional<CuentaAzure> eliminarCuentaAzurePorId(Long idCuentaAzure) {
        repositorioCuentaAzure.deleteById(idCuentaAzure);
        return Optional.empty();
    }

    @Override
    public List<CuentaAzure> listarCuentasAzure() {
        return repositorioCuentaAzure.findAll();
    }
}

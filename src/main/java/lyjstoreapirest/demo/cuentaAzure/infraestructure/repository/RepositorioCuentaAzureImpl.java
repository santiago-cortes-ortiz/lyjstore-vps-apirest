package lyjstoreapirest.demo.cuentaAzure.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAzure.domain.model.CuentaAzure;
import lyjstoreapirest.demo.cuentaAzure.domain.repository.JpaCuentasAzure;
import lyjstoreapirest.demo.cuentaAzure.domain.repository.RepositorioCuentaAzure;
import lyjstoreapirest.demo.general_service.Repositorio;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RepositorioCuentaAzureImpl implements RepositorioCuentaAzure {

    private JpaCuentasAzure jpaCuentasAzure;

    @Override
    public Long guardar(CuentaAzure cuentaAzure) {
        return jpaCuentasAzure.save(cuentaAzure).getIdCuentaAzure();
    }

    @Override
    public Optional<CuentaAzure> buscarCuentaAzurePorId(Long idCuentaAzure) {
        return jpaCuentasAzure.findById(idCuentaAzure);
    }

    @Override
    public Optional<CuentaAzure> eliminarCuentaAzurePorId(Long idCuentaAzure) {
        jpaCuentasAzure.deleteById(idCuentaAzure);
        return Optional.empty();
    }

    @Override
    public List<CuentaAzure> listarCuentasAzure()
    {
        return jpaCuentasAzure.findAll();
    }
}

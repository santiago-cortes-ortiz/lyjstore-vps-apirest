package lyjstoreapirest.demo.cuentaAmazon.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAmazon.domain.service.CuentaAmazonServicio;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.repository.RepositorioCuentaAmazon;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class CuentaAmazonServicioImpl implements CuentaAmazonServicio {

    private RepositorioCuentaAmazon repositorioCuentaAmazon;

    @Override
    public Long guardar(CuentaAmazon cuentaAmazon) {
        return repositorioCuentaAmazon.save(cuentaAmazon).getIdCuentaAmazon();
    }

    @Override
    public Optional<CuentaAmazon> buscarCuentaAmazonPorId(Long idCuentaAmazon) {
        return repositorioCuentaAmazon.findById(idCuentaAmazon);
    }

    @Override
    public Optional<CuentaAmazon> eliminarCuentaAmazonPorId(Long idCuentaAmazon) {
        repositorioCuentaAmazon.deleteById(idCuentaAmazon);
        return Optional.empty();
    }

    @Override
    public List<CuentaAmazon> listarCuentasAmazon() {
        return repositorioCuentaAmazon.findAll();
    }
}

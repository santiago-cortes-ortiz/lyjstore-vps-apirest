package lyjstoreapirest.demo.cuentaAmazon.domain.service;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAmazon.application.CuentaAmazonServicio;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.repository.RepositorioCuentaAmazon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

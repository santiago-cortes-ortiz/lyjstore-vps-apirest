package lyjstoreapirest.demo.cuentaAmazon.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAmazon.domain.dto.CuentaAmazonDTO;
import lyjstoreapirest.demo.cuentaAmazon.domain.service.CuentaAmazonServicio;
import lyjstoreapirest.demo.cuentaAmazon.infraestructure.entity.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.repository.RepositorioCuentaAmazon;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class CuentaAmazonServicioImpl implements CuentaAmazonServicio {

    private RepositorioCuentaAmazon repositorioCuentaAmazon;

    @Override
    public Long guardar(CuentaAmazonDTO cuentaAmazon) {
        return repositorioCuentaAmazon.guardar(cuentaAmazon);
    }

    @Override
    public CuentaAmazonDTO buscarCuentaAmazonPorId(Long idCuentaAmazon) {
        return repositorioCuentaAmazon.buscarCuentaAmazonPorId(idCuentaAmazon);
    }

    @Override
    public Optional<CuentaAmazonDTO> eliminarCuentaAmazonPorId(Long idCuentaAmazon) {
        return repositorioCuentaAmazon.eliminarCuentaAmazonPorId(idCuentaAmazon);

    }

    @Override
    public List<CuentaAmazonDTO> listarCuentasAmazon() {
        return repositorioCuentaAmazon.listarCuentasAmazon();
    }
}

package lyjstoreapirest.demo.cuentaAmazon.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.repository.JpaMetodosCuentaAmazon;
import lyjstoreapirest.demo.cuentaAmazon.domain.repository.RepositorioCuentaAmazon;
import lyjstoreapirest.demo.general_service.Repositorio;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor


public class RepositorioCuentaAmazonImpl implements RepositorioCuentaAmazon {

    private JpaMetodosCuentaAmazon jpaMetodosCuentaAmazon;


    @Override
    public Long guardar(CuentaAmazon cuentaAmazon) {
        return jpaMetodosCuentaAmazon.save(cuentaAmazon).getIdCuentaAmazon();
    }

    @Override
    public Optional<CuentaAmazon> buscarCuentaAmazonPorId(Long idCuentaAmazon) {
        return jpaMetodosCuentaAmazon.findById(idCuentaAmazon);
    }

    @Override
    public Optional<CuentaAmazon> eliminarCuentaAmazonPorId(Long idCuentaAmazon) {
        jpaMetodosCuentaAmazon.deleteById(idCuentaAmazon);
        return Optional.empty();

    }

    @Override
    public List<CuentaAmazon> listarCuentasAmazon() {
        return jpaMetodosCuentaAmazon.findAll();
    }
}

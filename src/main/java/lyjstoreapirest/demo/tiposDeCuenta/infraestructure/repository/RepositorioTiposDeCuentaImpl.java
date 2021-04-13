package lyjstoreapirest.demo.tiposDeCuenta.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Repositorio;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import lyjstoreapirest.demo.tiposDeCuenta.domain.repository.JpaMetodosTiposDeCuenta;
import lyjstoreapirest.demo.tiposDeCuenta.domain.repository.RepositorioTiposDeCuenta;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RepositorioTiposDeCuentaImpl implements RepositorioTiposDeCuenta {

    private JpaMetodosTiposDeCuenta jpaMetodosTiposDeCuenta;

    @Override
    public Long guardar(TipoDeCuenta tipoDeCuenta) {
        return jpaMetodosTiposDeCuenta.save(tipoDeCuenta).getId();
    }

    @Override
    public Optional<TipoDeCuenta> buscarTiposDeCuentaPorId(Long idTiposDeCuenta) {
        return jpaMetodosTiposDeCuenta.findById(idTiposDeCuenta);
    }

    @Override
    public Optional<TipoDeCuenta> eliminarTiposDeCuentaPorId(Long idTiposDeCuenta) {
        jpaMetodosTiposDeCuenta.deleteById(idTiposDeCuenta);
        return Optional.empty();
    }

    @Override
    public List<TipoDeCuenta> listarTiposDeCuenta() {
        return jpaMetodosTiposDeCuenta.findAll();
    }
}

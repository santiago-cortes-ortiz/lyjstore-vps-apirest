package lyjstoreapirest.demo.tiposDeCuenta.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.general_service.Servicio;
import lyjstoreapirest.demo.tiposDeCuenta.domain.service.TiposDeCuentaServicio;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import lyjstoreapirest.demo.tiposDeCuenta.domain.repository.RepositorioTiposDeCuenta;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class TiposDeCuentaServicioImpl implements TiposDeCuentaServicio {

    private RepositorioTiposDeCuenta repositorioTiposDeCuenta;

    @Override
    public Long guardar(TipoDeCuenta tipoDeCuenta) {
        return repositorioTiposDeCuenta.guardar(tipoDeCuenta);
    }

    @Override
    public Optional<TipoDeCuenta> buscarTiposDeCuentaPorId(Long idTiposDeCuenta) {
        return repositorioTiposDeCuenta.buscarTiposDeCuentaPorId(idTiposDeCuenta);
    }

    @Override
    public Optional<TipoDeCuenta> eliminarTiposDeCuentaPorId(Long idTiposDeCuenta) {
        repositorioTiposDeCuenta.eliminarTiposDeCuentaPorId(idTiposDeCuenta);
        return Optional.empty();
    }

    @Override
    public List<TipoDeCuenta> listarTiposDeCuenta() {
        return repositorioTiposDeCuenta.listarTiposDeCuenta();
    }
}

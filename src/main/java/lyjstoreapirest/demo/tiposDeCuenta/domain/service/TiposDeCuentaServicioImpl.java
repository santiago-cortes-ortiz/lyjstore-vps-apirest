package lyjstoreapirest.demo.tiposDeCuenta.domain.service;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.tiposDeCuenta.application.TiposDeCuentaServicio;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import lyjstoreapirest.demo.tiposDeCuenta.domain.repository.RepositorioTiposDeCuenta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TiposDeCuentaServicioImpl implements TiposDeCuentaServicio {

    private RepositorioTiposDeCuenta repositorioTiposDeCuenta;

    @Override
    public Long guardar(TipoDeCuenta tipoDeCuenta) {
        return repositorioTiposDeCuenta.save(tipoDeCuenta).getId();
    }

    @Override
    public Optional<TipoDeCuenta> buscarTiposDeCuentaPorId(Long idTiposDeCuenta) {
        return repositorioTiposDeCuenta.findById(idTiposDeCuenta);
    }

    @Override
    public Optional<TipoDeCuenta> eliminarTiposDeCuentaPorId(Long idTiposDeCuenta) {
        repositorioTiposDeCuenta.deleteById(idTiposDeCuenta);
        return Optional.empty();
    }

    @Override
    public List<TipoDeCuenta> listarTiposDeCuenta() {
        return repositorioTiposDeCuenta.findAll();
    }
}

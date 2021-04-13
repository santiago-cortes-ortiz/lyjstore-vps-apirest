package lyjstoreapirest.demo.tiposDeCuenta.domain.repository;

import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioTiposDeCuenta  {
    Long guardar(TipoDeCuenta tipoDeCuenta);

    Optional<TipoDeCuenta> buscarTiposDeCuentaPorId(Long idTiposDeCuenta);

    Optional<TipoDeCuenta> eliminarTiposDeCuentaPorId(Long idTiposDeCuenta);

    List<TipoDeCuenta> listarTiposDeCuenta();
}

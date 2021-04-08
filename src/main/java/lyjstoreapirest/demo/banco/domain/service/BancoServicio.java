package lyjstoreapirest.demo.banco.domain.service;

import lyjstoreapirest.demo.banco.domain.model.Banco;

import java.util.List;
import java.util.Optional;

public interface BancoServicio {

    Long guardar(Banco banco);

    Optional<Banco> buscarBancoPorId(Long idBanco);

    Optional<Banco> eliminarBancoPorId(Long idBanco);

    List<Banco> listarBancos();


}

package lyjstoreapirest.demo.banco.domain.service;

import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.model.Banco;

import java.util.List;
import java.util.Optional;

public interface BancoCrud {

    Long guardar(BancoDTO banco);

    Optional<BancoDTO> buscarBancoPorId(Long idBanco);

    Optional<BancoDTO> eliminarBancoPorId(Long idBanco);

    List<BancoDTO> listarBancos();


}

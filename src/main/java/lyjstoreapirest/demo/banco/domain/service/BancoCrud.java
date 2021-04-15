package lyjstoreapirest.demo.banco.domain.service;

import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;

import java.util.List;
import java.util.Optional;

public interface BancoCrud {

    Long guardar(BancoDTO banco);

    BancoDTO buscarBancoPorId(Long idBanco) throws Exception;

    Optional<BancoDTO> eliminarBancoPorId(Long idBanco);

    List<BancoDTO> listarBancos();


}

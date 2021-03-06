package lyjstoreapirest.demo.banco.domain.service;

import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;

import java.util.List;
import java.util.Optional;

public interface BancoController {

    Long guardar(BancoDTO banco);

    Optional<BancoDTO> buscarBancoPorId(Long idBanco);

    boolean eliminarBancoPorId(Long idBanco);

    List<BancoDTO> listarBancos();

    Long actualizarBanco(BancoDTO bancoDTO, Long idBanco);

}

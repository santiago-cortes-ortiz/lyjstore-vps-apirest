package lyjstoreapirest.demo.banco.domain.repository;

import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;


import java.util.List;
import java.util.Optional;

public interface RespositorioBanco{

    Long guardar(BancoDTO bancoDTO);

    Optional<BancoDTO> buscarBancoPorId(Long idBanco);

    boolean eliminarBancoPorId(Long idBanco);

    List<BancoDTO> listarBancos();

    Long actualizarBanco(BancoDTO bancoDTO,Long id);
}

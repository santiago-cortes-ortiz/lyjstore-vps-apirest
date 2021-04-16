package lyjstoreapirest.demo.banco.domain.repository;

import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;

import java.util.List;
import java.util.Optional;

public interface RespositorioBanco{

    Long guardar(BancoDTO bancoDTO);

    BancoDTO buscarBancoPorId(Long idBanco) throws Exception;

    Optional<BancoDTO> eliminarBancoPorId(Long idBanco);

    List<BancoDTO> listarBancos();

    void actualizarBanco(BancoDTO bancoDTO,Long id);
}

package lyjstoreapirest.demo.banco.infrastucture;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import lyjstoreapirest.demo.banco.infrastucture.mapper.BancoMapper;
import lyjstoreapirest.demo.banco.infrastucture.repository.JpaMetodosBanco;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.general_service.Repositorio;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RespositorioBancoImpl implements RespositorioBanco  {

    private JpaMetodosBanco jpaMetodosBanco;
    private BancoMapper bancoMapper;


    @Override
    public Long guardar(BancoDTO bancoDTO) {
        return jpaMetodosBanco.save(bancoMapper.bancoDtoToBanco(bancoDTO)).getId();
    }

    @Override
    public BancoDTO buscarBancoPorId(Long idBanco) throws Exception {
        return bancoMapper.bancoToBancoDto(jpaMetodosBanco.findById(idBanco).get());
    }

    @Override
    public Optional<BancoDTO> eliminarBancoPorId(Long idBanco) {
        jpaMetodosBanco.deleteById(idBanco);
        return Optional.empty();
    }

    @Override
    public List<BancoDTO> listarBancos() {
        return null;
    }
}

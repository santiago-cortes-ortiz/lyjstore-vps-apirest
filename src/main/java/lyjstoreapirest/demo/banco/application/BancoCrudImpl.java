package lyjstoreapirest.demo.banco.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.service.BancoCrud;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.banco.infrastucture.mapper.BancoMapper;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class BancoCrudImpl implements BancoCrud {

    private RespositorioBanco respositorioBanco;
    private BancoMapper bancoMapper;

    @Override
    public Long guardar(BancoDTO banco) {
        Banco banquito = bancoMapper.bancoDtoToBanco(banco);
        Long bancoAGuardar = respositorioBanco.guardar(banquito);
        return bancoAGuardar;
    }

    @Override
    public Optional<BancoDTO> buscarBancoPorId(Long idBanco)
    {
        return respositorioBanco.buscarBancoPorId(idBanco).map(banco -> BancoDTO.builder()
                .id(banco.getId())
                .nombre(banco.getNombre())
                .build());
    }

    @Override
    public Optional<Banco> eliminarBancoPorId(Long idBanco)
    {
        return respositorioBanco.eliminarBancoPorId(idBanco);
    }

    @Override
    public List<Banco> listarBancos() {
        return respositorioBanco.listarBancos();
    }


}

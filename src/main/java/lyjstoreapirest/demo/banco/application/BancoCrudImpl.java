package lyjstoreapirest.demo.banco.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.service.BancoCrud;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.banco.infrastucture.mapper.BancoMapper;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Servicio
@AllArgsConstructor
public class BancoCrudImpl implements BancoCrud {

    private RespositorioBanco respositorioBanco;

    @Override
    public Long guardar(BancoDTO banco) {
        return respositorioBanco.guardar(banco);
    }

    @Override
    public BancoDTO buscarBancoPorId(Long idBanco) throws Exception
    {
        return respositorioBanco.buscarBancoPorId(idBanco);
    }

    @Override
    public Optional<BancoDTO> eliminarBancoPorId(Long idBanco)
    {
        return respositorioBanco.eliminarBancoPorId(idBanco).map(banco -> BancoDTO.builder()
                .id(banco.getId())
                .nombre(banco.getNombre())
                .build());
    }

    @Override
    public List<BancoDTO> listarBancos() {
        return respositorioBanco.listarBancos();
    }




}

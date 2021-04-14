package lyjstoreapirest.demo.banco.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.service.BancoCrud;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.banco.infrastucture.mapper.BancoMapper;
import lyjstoreapirest.demo.general_service.Servicio;

import java.sql.DataTruncation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Servicio
@AllArgsConstructor
public class BancoCrudImpl implements BancoCrud {

    private RespositorioBanco respositorioBanco;
    private BancoMapper bancoMapper;

    @Override
    public Long guardar(BancoDTO banco) {
        Banco banquito = bancoMapper.bancoDtoToBanco(banco);
        return respositorioBanco.guardar(banquito);
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
    public Optional<BancoDTO> eliminarBancoPorId(Long idBanco)
    {
        return respositorioBanco.eliminarBancoPorId(idBanco).map(banco -> BancoDTO.builder()
                .id(banco.getId())
                .nombre(banco.getNombre())
                .build());
    }

    @Override
    public List<BancoDTO> listarBancos() {
        List<Banco> listaBancoNormales = respositorioBanco.listarBancos();
        List<BancoDTO> listaBancoDto = listaBancoNormales.stream().map(listaDto -> BancoDTO.builder()
                .id(listaDto.getId())
                .nombre(listaDto.getNombre())
                .build())
                .collect(Collectors.toList());
        return listaBancoDto;
    }


}

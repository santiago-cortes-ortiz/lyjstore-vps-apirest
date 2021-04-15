package lyjstoreapirest.demo.banco.infrastucture.mapper;

import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import org.mapstruct.Mapper;

@Mapper
public abstract class BancoMapper {

    public Banco bancoDtoToBanco(BancoDTO bancoDTO){
        return Banco.builder().id(bancoDTO.getId())
                .nombre(bancoDTO.getNombre())
                .build();
    }

    public BancoDTO bancoToBancoDto(Banco banco){
        return BancoDTO.builder().id(banco.getId())
                .nombre(banco.getNombre())
                .build();
    }

}

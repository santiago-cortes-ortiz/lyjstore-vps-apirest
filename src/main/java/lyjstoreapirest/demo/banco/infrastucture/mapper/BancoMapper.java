package lyjstoreapirest.demo.banco.infrastucture.mapper;

import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import org.mapstruct.Mapper;

@Mapper
public interface BancoMapper {

    public Banco bancoDtoToBanco(BancoDTO bancoDTO);

}

package lyjstoreapirest.demo.banco.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.banco.domain.service.BancoController;
import lyjstoreapirest.demo.general_service.Servicio;


import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class BancoControllerFull implements BancoController {

    private RespositorioBanco respositorioBanco;

    @Override
    public Long guardar(BancoDTO banco) {
        return respositorioBanco.guardar(banco);
    }

    @Override
    public Optional<BancoDTO> buscarBancoPorId(Long idBanco)
    {
        return respositorioBanco.buscarBancoPorId(idBanco);
    }

    @Override
    public boolean eliminarBancoPorId(Long idBanco)
    {
        return respositorioBanco.eliminarBancoPorId(idBanco);
    }

    @Override
    public List<BancoDTO> listarBancos() {
        return respositorioBanco.listarBancos();
    }

    @Override
    public Long actualizarBanco(BancoDTO bancoDTO, Long idBanco) {
        return respositorioBanco.actualizarBanco(bancoDTO,idBanco);
    }


}

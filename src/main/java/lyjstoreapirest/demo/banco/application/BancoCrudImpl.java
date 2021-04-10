package lyjstoreapirest.demo.banco.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.service.BancoCrud;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class BancoCrudImpl implements BancoCrud {

    private RespositorioBanco respositorioBanco;

    @Override
    public Long guardar(Banco banco) {
        Long bancoAGuardar = respositorioBanco.guardar(banco);
        return bancoAGuardar;
    }

    @Override
    public Optional<Banco> buscarBancoPorId(Long idBanco)
    {
        return respositorioBanco.buscarBancoPorId(idBanco);
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

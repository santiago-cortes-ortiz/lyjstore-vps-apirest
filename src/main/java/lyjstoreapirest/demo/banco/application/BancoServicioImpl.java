package lyjstoreapirest.demo.banco.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.service.BancoServicio;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class BancoServicioImpl implements BancoServicio {

    private RespositorioBanco respositorioBanco;

    @Override
    public Long guardar(Banco banco) {
        Banco bancoAGuardar = respositorioBanco.save(banco);
        return bancoAGuardar.getId();
    }

    @Override
    public Optional<Banco> buscarBancoPorId(Long idBanco)
    {
        return respositorioBanco.findById(idBanco);
    }


    @Override
    public Optional<Banco> eliminarBancoPorId(Long idBanco)
    {
        respositorioBanco.deleteById(idBanco);
        return Optional.empty();
    }

    @Override
    public List<Banco> listarBancos() {
        return respositorioBanco.findAll();
    }


}

package lyjstoreapirest.demo.banco.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.repository.Respositorio;
import lyjstoreapirest.demo.banco.domain.service.BancoServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BancoServicioImpl implements BancoServicio {

    private Respositorio respositorio;

    @Override
    public Long guardar(Banco banco) {
        Banco bancoAGuardar = respositorio.save(banco);
        return bancoAGuardar.getId();
    }

    @Override
    public Optional<Banco> buscarBancoPorId(Long idBanco)
    {
        return respositorio.findById(idBanco);
    }


    @Override
    public Optional<Banco> eliminarBancoPorId(Long idBanco)
    {
        respositorio.deleteById(idBanco);
        return Optional.empty();
    }

    @Override
    public List<Banco> listarBancos() {
        return respositorio.findAll();
    }


}

package lyjstoreapirest.demo.banco.infrastucture.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.repository.JpaMethods;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RespositorioBancoImpl implements RespositorioBanco {

    private JpaMethods jpaMethods;

    @Override
    public Long guardar(Banco banco) {
        return jpaMethods.save(banco).getId();
    }

    @Override
    public Optional<Banco> buscarBancoPorId(Long idBanco) {
        return jpaMethods.findById(idBanco);
    }

    @Override
    public Optional<Banco> eliminarBancoPorId(Long idBanco) {
        jpaMethods.deleteById(idBanco);
        return Optional.empty();
    }

    @Override
    public List<Banco> listarBancos() {
        return jpaMethods.findAll();
    }
}

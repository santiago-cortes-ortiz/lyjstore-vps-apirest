package lyjstoreapirest.demo.banco.infrastucture.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.banco.domain.repository.JpaMetodosBanco;
import lyjstoreapirest.demo.banco.domain.repository.RespositorioBanco;
import lyjstoreapirest.demo.general_service.Repositorio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RespositorioBancoImpl implements RespositorioBanco {

    private JpaMetodosBanco jpaMetodosBanco;

    @Override
    public Long guardar(Banco banco) {
        return jpaMetodosBanco.save(banco).getId();
    }

    @Override
    public Optional<Banco> buscarBancoPorId(Long idBanco) {
        return jpaMetodosBanco.findById(idBanco);
    }

    @Override
    public Optional<Banco> eliminarBancoPorId(Long idBanco) {
        jpaMetodosBanco.deleteById(idBanco);
        return Optional.empty();
    }

    @Override
    public List<Banco> listarBancos() {
        return jpaMetodosBanco.findAll();
    }
}

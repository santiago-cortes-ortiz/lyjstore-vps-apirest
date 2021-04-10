package lyjstoreapirest.demo.banco.domain.repository;

import lyjstoreapirest.demo.banco.domain.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RespositorioBanco{

    Long guardar(Banco banco);

    Optional<Banco> buscarBancoPorId(Long idBanco);

    Optional<Banco> eliminarBancoPorId(Long idBanco);

    List<Banco> listarBancos();

}

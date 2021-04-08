package lyjstoreapirest.demo.banco.domain.repository;

import lyjstoreapirest.demo.banco.domain.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RespositorioBanco extends JpaRepository <Banco,Long>{

}

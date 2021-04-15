package lyjstoreapirest.demo.banco.infrastucture.repository;

import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMetodosBanco extends JpaRepository<Banco,Long>
{

}

package lyjstoreapirest.demo.banco.domain.repository;

import lyjstoreapirest.demo.banco.domain.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMethods extends JpaRepository<Banco,Long> {

}

package lyjstoreapirest.demo.usuario.domain.repository;

import lyjstoreapirest.demo.usuario.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsuario extends JpaRepository<Usuario,String> {
}

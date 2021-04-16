package lyjstoreapirest.demo.courier.infraestructure.repository;

import lyjstoreapirest.demo.courier.infraestructure.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMetodosCourier extends JpaRepository<Courier,Long> {

}

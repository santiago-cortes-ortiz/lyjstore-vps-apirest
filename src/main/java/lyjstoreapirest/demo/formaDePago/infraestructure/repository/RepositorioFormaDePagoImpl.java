package lyjstoreapirest.demo.formaDePago.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.formaDePago.domain.repository.JpaFormaDePago;
import lyjstoreapirest.demo.formaDePago.domain.repository.RepositorioFormaDePago;
import lyjstoreapirest.demo.general_service.Repositorio;


import java.util.List;
import java.util.Optional;

@Repositorio
@AllArgsConstructor
public class RepositorioFormaDePagoImpl implements RepositorioFormaDePago
{
 private JpaFormaDePago jpaFormaDePago;


 @Override
 public Long guardar(FormaDePago formaDePago) {
  return jpaFormaDePago.save(formaDePago).getId();
 }

 @Override
 public Optional<FormaDePago> buscarFormaDePagoPorId(Long idFormaDePago)
 {
  return jpaFormaDePago.findById(idFormaDePago);
 }

 @Override
 public Optional<FormaDePago> eliminarFormaDePagoPorId(Long idFormaDePago)
 {
  jpaFormaDePago.deleteById(idFormaDePago);
  return Optional.empty();
 }

 @Override
 public List<FormaDePago> listarFormasDePago() {
  return jpaFormaDePago.findAll();
 }
}

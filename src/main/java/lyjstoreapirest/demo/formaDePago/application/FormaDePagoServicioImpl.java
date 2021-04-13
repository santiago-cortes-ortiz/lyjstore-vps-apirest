package lyjstoreapirest.demo.formaDePago.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.service.FormaDePagoServicio;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.formaDePago.domain.repository.RepositorioFormaDePago;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;

@Servicio
@AllArgsConstructor
public class FormaDePagoServicioImpl implements FormaDePagoServicio {

    private RepositorioFormaDePago repositorioFormaDePago;

    @Override
    public Long guardar(FormaDePago formaDePago) {
        return repositorioFormaDePago.guardar(formaDePago);
    }

    @Override
    public Optional<FormaDePago> buscarFormaDePagoPorId(Long idFormaDePago) {
        return repositorioFormaDePago.buscarFormaDePagoPorId(idFormaDePago);
    }

    @Override
    public Optional<FormaDePago> eliminarFormaDePagoPorId(Long idFormaDePago) {
        repositorioFormaDePago.eliminarFormaDePagoPorId(idFormaDePago);
        return Optional.empty();
    }

    @Override
    public List<FormaDePago> listarFormasDePago() {
        return repositorioFormaDePago.listarFormasDePago();
    }

}

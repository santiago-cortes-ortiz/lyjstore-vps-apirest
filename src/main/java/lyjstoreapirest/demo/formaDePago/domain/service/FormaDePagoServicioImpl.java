package lyjstoreapirest.demo.formaDePago.domain.service;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.formaDePago.application.FormaDePagoServicio;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.formaDePago.domain.repository.RepositorioFormaDePago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FormaDePagoServicioImpl implements FormaDePagoServicio {

    private RepositorioFormaDePago repositorioFormaDePago;

    @Override
    public Long guardar(FormaDePago formaDePago) {
        return repositorioFormaDePago.save(formaDePago).getId();
    }

    @Override
    public Optional<FormaDePago> buscarFormaDePagoPorId(Long idFormaDePago) {
        return repositorioFormaDePago.findById(idFormaDePago);
    }

    @Override
    public Optional<FormaDePago> eliminarFormaDePagoPorId(Long idFormaDePago) {
        repositorioFormaDePago.deleteById(idFormaDePago);
        return Optional.empty();
    }

    @Override
    public List<FormaDePago> listarFormasDePago() {
        return repositorioFormaDePago.findAll();
    }

}

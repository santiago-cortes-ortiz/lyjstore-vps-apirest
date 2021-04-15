package lyjstoreapirest.demo.courier.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.domain.service.CourierCrud;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.courier.domain.repository.RepositorioCourier;
import lyjstoreapirest.demo.courier.infraestructure.mapper.CourierMapper;
import lyjstoreapirest.demo.general_service.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Servicio
@AllArgsConstructor
public class CourierCrudImpl implements CourierCrud {

    private final RepositorioCourier repositorioCourier;
    private final CourierMapper courierMapper;

    @Override
    public Long guardar(CourierDTO courier) {
        Courier courierAGuardar = courierMapper.courierDtoToCourier(courier);
        return repositorioCourier.guardar(courierAGuardar);
    }

    @Override
    public Optional<CourierDTO> buscarCourierPorId(Long idCourier) {
        return repositorioCourier.buscarCourierPorId(idCourier).map(courier -> CourierDTO.builder()
                .id(courier.getId())
                .nombre(courier.getNombre())
                .build()
        );
    }

    @Override
    public Optional<CourierDTO> eliminarCourierPorId(Long idCourier) {
        return repositorioCourier.eliminarCourierPorId(idCourier).map(courier -> CourierDTO.builder()
                .id(courier.getId())
                .nombre(courier.getNombre())
                .build());
    }

    @Override
    public List<CourierDTO> listarCouriers() {
        List<Courier> listarCouriersNormales = repositorioCourier.listarCouriers();
        return listarCouriersNormales.stream().map(listaDto -> CourierDTO.builder()
                .id(listaDto.getId())
                .nombre(listaDto.getNombre())
                .build())
                .collect(Collectors.toList());
    }
}

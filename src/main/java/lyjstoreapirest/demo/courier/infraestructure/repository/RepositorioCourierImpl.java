package lyjstoreapirest.demo.courier.infraestructure.repository;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.banco.domain.dto.BancoDTO;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.infraestructure.entity.Courier;
import lyjstoreapirest.demo.courier.domain.repository.RepositorioCourier;
import lyjstoreapirest.demo.courier.infraestructure.mapper.CourierMapper;
import lyjstoreapirest.demo.general_service.Repositorio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repositorio
@AllArgsConstructor
public class RepositorioCourierImpl implements RepositorioCourier {

    private final JpaMetodosCourier jpaMetodosCourier;
    private final CourierMapper courierMapper;

    @Override
    public Long guardar(CourierDTO courier) {
        return courierMapper.courierDtoToCourier(courier).getId() ;
    }

    @Override
    public CourierDTO buscarCourierPorId(Long idCourier) {
        return courierMapper.courierToCourierDto(jpaMetodosCourier.findById(idCourier).get());
    }

    @Override
    public Optional<CourierDTO> eliminarCourierPorId(Long idCourier) {
        jpaMetodosCourier.deleteById(idCourier);
        return Optional.empty();
    }

    @Override
    public List<CourierDTO> listarCouriers() {
        List<Courier> listaCouriersNormales = jpaMetodosCourier.findAll();
        List<CourierDTO> listaCouriersDto = listaCouriersNormales.stream().map(listaDto -> CourierDTO.builder()
                .id(listaDto.getId())
                .nombre(listaDto.getNombre())
                .build())
                .collect(Collectors.toList());
        return listaCouriersDto;
    }
}

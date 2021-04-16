package lyjstoreapirest.demo.courier.application;

import lombok.AllArgsConstructor;
import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.domain.service.CourierCrud;
import lyjstoreapirest.demo.courier.infraestructure.entity.Courier;
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

    @Override
    public Long guardar(CourierDTO courier) {
        return repositorioCourier.guardar(courier);
    }

    @Override
    public CourierDTO buscarCourierPorId(Long idCourier) {
        return repositorioCourier.buscarCourierPorId(idCourier);
    }

    @Override
    public Optional<CourierDTO> eliminarCourierPorId(Long idCourier) {
        return repositorioCourier.eliminarCourierPorId(idCourier);
    }

    @Override
    public List<CourierDTO> listarCouriers() {
        return repositorioCourier.listarCouriers();
    }

    public void actualizarCourier(CourierDTO courierDTO, Long id){

        /*Optional<Courier> courierABuscar = repositorioCourier.buscarCourierPorId(id);

        if (courierABuscar.isEmpty()){
            courierABuscar.get().setId(id);
            courierABuscar.get().setNombre(courierDTO.getNombre());
            repositorioCourier.guardar(courierABuscar.get());
        }
        else{
            courierABuscar.get().setNombre(courierDTO.getNombre());
            repositorioCourier.guardar(courierABuscar.get());
        }
*/

    }
}

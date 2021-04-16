package lyjstoreapirest.demo.courier.infraestructure.mapper;

import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.infraestructure.entity.Courier;
import org.mapstruct.Mapper;

@Mapper
public abstract class CourierMapper {

    public Courier courierDtoToCourier(CourierDTO courierDTO){
        return Courier.builder()
                .id(courierDTO.getId())
                .nombre(courierDTO.getNombre())
                .build();
    }

    public CourierDTO courierToCourierDto(Courier courier){
        return CourierDTO.builder()
                .id(courier.getId())
                .nombre(courier.getNombre())
                .build();
    }

}

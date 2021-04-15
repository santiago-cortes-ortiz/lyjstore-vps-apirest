package lyjstoreapirest.demo.courier.infraestructure.mapper;

import lyjstoreapirest.demo.courier.domain.dto.CourierDTO;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import org.mapstruct.Mapper;

@Mapper
public interface CourierMapper {

    public Courier courierDtoToCourier(CourierDTO courierDTO);

}

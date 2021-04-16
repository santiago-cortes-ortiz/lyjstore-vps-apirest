package lyjstoreapirest.demo.cuentaAmazon.infraestructure.mapper;

import lyjstoreapirest.demo.cuentaAmazon.domain.dto.CuentaAmazonDTO;
import lyjstoreapirest.demo.cuentaAmazon.infraestructure.entity.CuentaAmazon;
import org.mapstruct.Mapper;

@Mapper
public abstract class CuentaAmazonMapper {

    public CuentaAmazon cuentaAmazonDtoToCuentaAmazon(CuentaAmazonDTO cuentaAmazonDTO){
        return CuentaAmazon.builder()
                .idCuentaAmazon(cuentaAmazonDTO.getIdCuentaAmazon())
                .nombre(cuentaAmazonDTO.getNombre())
                .correo(cuentaAmazonDTO.getCorreo())
                .direccion(cuentaAmazonDTO.getDireccion())
                .direccion2(cuentaAmazonDTO.getDireccion2())
                .codigoPostal(cuentaAmazonDTO.getCodigoPostal())
                .telefono(cuentaAmazonDTO.getTelefono())
                .ciudad(cuentaAmazonDTO.getCiudad())
                .estado(cuentaAmazonDTO.getEstado())
                .build();
    }

    public CuentaAmazonDTO cuentaAmazonToCuentaAmazonDto(CuentaAmazon cuentaAmazon){
        return CuentaAmazonDTO.builder()
                .idCuentaAmazon(cuentaAmazon.getIdCuentaAmazon())
                .nombre(cuentaAmazon.getNombre())
                .correo(cuentaAmazon.getCorreo())
                .direccion(cuentaAmazon.getDireccion())
                .direccion2(cuentaAmazon.getDireccion2())
                .codigoPostal(cuentaAmazon.getCodigoPostal())
                .telefono(cuentaAmazon.getTelefono())
                .ciudad(cuentaAmazon.getCiudad())
                .estado(cuentaAmazon.getEstado())
                .build();
    }

}

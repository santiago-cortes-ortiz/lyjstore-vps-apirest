package lyjstoreapirest.demo.cuentaAmazon.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
@Builder
public class CuentaAmazonDTO {
    private Long idCuentaAmazon;
    private String nombre;
    private String correo;
    private String direccion;
    private String direccion2;
    private Integer codigoPostal;
    private Long telefono;
    private String ciudad;
    private String estado;
}

package lyjstoreapirest.demo.cuentaAmazon.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuentas_amazon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CuentaAmazon implements Serializable {

    private static final long serialVersionUID = -605694708703918022L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long idCuentaAmazon;
    private String nombre;
    private String correo;
    private String direccion;
    private String direccion2;
    @Column(name = "codigo_postal")
    private Integer codigoPostal;
    private Long telefono;
    private String ciudad;
    private String estado;
}

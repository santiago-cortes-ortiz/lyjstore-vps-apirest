package lyjstoreapirest.demo.cuentaAzure.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cuentas_azure")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CuentaAzure implements Serializable {
    private static final long serialVersionUID = -3800580143611271956L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long idCuentaAzure;
    private String correo;
    @Column(name = "contraseña")
    private String contrasenia;
    @Column(name = "pais_creacion")
    private String paisCreacion;
}

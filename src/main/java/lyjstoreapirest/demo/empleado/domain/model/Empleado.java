package lyjstoreapirest.demo.empleado.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;
import lyjstoreapirest.demo.metodoDePago.domain.model.MetodoPago;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Empleado {

    @Id
    private Long cedula;

    private String nombre;

    private String apellido;

    private Double telefono;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "fk_tipo_metodo_pago")
    private Long idFormaDePago;

    @OneToOne
    @JoinColumn(name = "fk_tipo_metodo_pago",updatable = false,insertable = false)
    private FormaDePago formaDePago;

}

package lyjstoreapirest.demo.usuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.empleado.domain.model.Empleado;
import lyjstoreapirest.demo.rol.domain.model.Rol;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private String usuario;

    @Column(name = "contraseña")
    private String contrasenia;

    @Column(name = "fk_rol_id")
    private Long idRol;

    @Column(name = "fk_empleadoscedula")
    private Long idEmpleado;

    @ManyToOne
    @JoinColumn(name = "fk_rol_id",insertable = false,updatable = false)
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "fk_empleadoscedula",updatable = false,insertable = false)
    private Empleado empleado;
}

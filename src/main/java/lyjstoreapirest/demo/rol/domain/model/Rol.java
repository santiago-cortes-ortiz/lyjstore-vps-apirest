package lyjstoreapirest.demo.rol.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rol {
    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    private String rol;
}

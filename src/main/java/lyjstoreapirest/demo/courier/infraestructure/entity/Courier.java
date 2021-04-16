package lyjstoreapirest.demo.courier.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Courier implements Serializable {
    private static final long serialVersionUID = -3524714540688134873L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_courier")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
}

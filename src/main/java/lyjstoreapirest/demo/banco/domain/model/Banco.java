package lyjstoreapirest.demo.banco.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bancos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Banco {
    @Id
    @Column( name = "id_bancos")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "nombre_banco"
    )
    private String nombre;

   /* @OneToMany(mappedBy = "banco")
    private List<FormaDePago> formasDePagos;*/
}

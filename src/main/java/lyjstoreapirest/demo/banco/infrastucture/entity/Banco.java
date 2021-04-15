package lyjstoreapirest.demo.banco.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.formaDePago.domain.model.FormaDePago;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bancos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Banco implements Serializable {
    private static final long serialVersionUID = -971502324171159506L;
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

package lyjstoreapirest.demo.tiposDeCuenta.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tipos_de_cuenta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoDeCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_de_cuenta")
    private Long id;
    @Column(name = "tipo")
    private String tipo;
}

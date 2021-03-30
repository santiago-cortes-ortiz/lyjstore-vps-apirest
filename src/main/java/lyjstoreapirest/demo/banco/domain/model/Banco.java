package lyjstoreapirest.demo.banco.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bancos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Banco {
    @Id
    @Column( name = "id_bancos")
    private Long id;
    @Column( name = "nombre_banco")
    private String nombre;
}

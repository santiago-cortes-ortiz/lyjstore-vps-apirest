package lyjstoreapirest.demo.producto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto implements Serializable {
    private static final long serialVersionUID = -816296611496377118L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private String nombre;
    @Column(name = "precio_venta")
    private Double precioVenta;
    private Integer upc;
}

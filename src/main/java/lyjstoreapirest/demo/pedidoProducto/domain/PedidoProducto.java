package lyjstoreapirest.demo.pedidoProducto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.pedido.domain.model.Pedido;
import lyjstoreapirest.demo.producto.domain.model.Producto;

import javax.persistence.*;

@Entity
@Table(name = "pedidos_productos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoProducto {

    @EmbeddedId
    private PedidoPorductoPK idPedidoProducto;

    private Integer catidad;

    private Double precio;

    @JoinColumn(name = "pedidosid_pedido",referencedColumnName = "id_Pedido",nullable = false,updatable = false,insertable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;

    @JoinColumn(name = "productosid_producto",referencedColumnName = "id_Producto",nullable = false,updatable = false,insertable = false)
    @ManyToOne(optional = false)
    private Producto producto;


}

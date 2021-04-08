package lyjstoreapirest.demo.pedidoProducto.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoPorductoPK implements Serializable {

    private static final long serialVersionUID = 5677385488809340229L;

    @NotNull
    @Basic(optional = false)
    @Column(name = "pedidosid_pedido", nullable = false, insertable = false, updatable = false)
    private Long idPedido;

    @NotNull
    @Basic(optional = false)
    @Column(name = "productosid_producto", nullable = false, insertable = false, updatable = false)
    private Long idProducto;

}

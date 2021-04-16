package lyjstoreapirest.demo.pedido.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.courier.infraestructure.entity.Courier;
import lyjstoreapirest.demo.cuentaAmazon.infraestructure.entity.CuentaAmazon;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido implements Serializable
{

    private static final long serialVersionUID = -4777046203696545729L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    private LocalDate fecha;

    @Column(name = "precio_envio")
    private Double precioEnvio;

    @Column(name = "precio_impuestos")
    private Double precioImpuestos;

    private String guia;

    @Column(name = "fk_courierid_courier")
    private Long idCourier;

    @Column(name = "fk_cuentas_amazonid_cuenta")
    private Long idCuentaAmazon;

    @OneToOne
    @JoinColumn(name = "fk_courierid_courier",insertable = false,updatable = false)
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "fk_cuentas_amazonid_cuenta",insertable = false,updatable = false)
    private CuentaAmazon cuentaAmazon;

}

package lyjstoreapirest.demo.pedido.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.courier.domain.model.Courier;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {

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
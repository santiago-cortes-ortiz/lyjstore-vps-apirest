package lyjstoreapirest.demo.metodoDePago.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import lyjstoreapirest.demo.cuentaAmazon.domain.model.CuentaAmazon;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "metodos_pago")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 8126620823126118020L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Long idTarjeta;

    @Column(name = "numero_tarjeta")
    private Integer numeroTarjeta;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "fk_cuentas_amazonid_cuenta")
    private Long idCuentaAmazon;

    @Column(name = "bancosid_bancos")
    private Long idBanco;

    @ManyToOne()
    @JoinColumn(name = "fk_cuentas_amazonid_cuenta",updatable = false,insertable = false)
    private CuentaAmazon cuentaAmazon;

    @OneToOne()
    @JoinColumn(name = "bancosid_bancos",insertable = false,updatable = false)
    private Banco banco;



}

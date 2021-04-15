package lyjstoreapirest.demo.formaDePago.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.banco.infrastucture.entity.Banco;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formas_pagos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormaDePago implements Serializable {

    private static final long serialVersionUID = 4395379119932663587L;
    @Id
    @Column(name = "metodo_banco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_pagos")
    private Long numeroPagos;

    @Column( name = "bancosid_bancos")
    private Long idBanco;

    @Column(name = "tipos_de_cuentaid_tipo_de_cuenta")
    private Long idTipoDeCuenta;

    @ManyToOne
    @JoinColumn(name = "bancosid_bancos",insertable = false,updatable = false)
    private Banco banco;

    @ManyToOne
    @JoinColumn( name = "tipos_de_cuentaid_tipo_de_cuenta",insertable = false,updatable = false)
    private TipoDeCuenta tipoDeCuenta;
}

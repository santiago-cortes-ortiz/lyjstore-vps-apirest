package lyjstoreapirest.demo.formaDePago.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lyjstoreapirest.demo.banco.domain.model.Banco;
import lyjstoreapirest.demo.tiposDeCuenta.domain.model.TipoDeCuenta;

import javax.persistence.*;

@Entity
@Table(name = "formas_pagos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormaDePago {

    @Id
    @Column(name = "metodo_banco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_pagos")
    private Integer numeroPagos;

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

package com.example.demo.model.entities;

import javax.persistence.*;

import com.example.demo.model.entities.enums.TipoPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
public class Pedido {

//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pedido")
   // private FormaPagamento formapag;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_pedido;

    @Column
//    @NotBlank(message = "Campo tipopedido é obrigatorio")
    private Integer tipoPedido;

@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime datapedido;

@OneToOne
@JoinColumn(name = "orcamento_id")
private Orcamento orcamento;

@OneToOne
@JoinColumn(name = "formapagamento_id")
private FormaPagamento formapagamento;
    public Pedido() {
        super();
        // TODO Auto-generated constructor stub
		this.datapedido = LocalDateTime.now();
    }

    public Pedido(TipoPedido tipoPedido) {
        super();
        this.tipoPedido = (tipoPedido == null) ? null : tipoPedido.getCod();
        this.datapedido = LocalDateTime.now();
    }



    public Integer getId_pedido() {
        return id_pedido;
    }


    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public TipoPedido getTipoPedido() throws IllegalAccessException {
        return TipoPedido.toEnum(tipoPedido);
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido.getCod();
    }


//    public String getTipopedido() {
//
//
//        if(tipopedido.equalsIgnoreCase("1")) {
//            tipopedido=("JANELA");
//        }
//        if(tipopedido.equalsIgnoreCase("2")) {
//            tipopedido=("PORTA");
//        }
//        if(tipopedido.equalsIgnoreCase("3")) {
//            tipopedido=("PORTAO");
//                }
//        if(tipopedido.equalsIgnoreCase("4")) {
//            tipopedido=("TOLDO");
//        }
//        // else {
//        //
//        //     }
//        return tipopedido;
//    }
//
//    public void setTipopedido(String tipopedido) {
//
//        this.tipopedido = tipopedido;
//
//    }

    @Override
    public String toString() {
        return "" + this.tipoPedido;
    }
}
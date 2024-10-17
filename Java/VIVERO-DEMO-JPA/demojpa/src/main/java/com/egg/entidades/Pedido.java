package com.egg.entidades;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;

    @Column(length = 255)
    private String codigo_pedido;

    @Column(length = 255)
    private String comentarios;

    @Column(length = 255)
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_entrega;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_esperada;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Getters y setters
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_esperada() {
        return fecha_esperada;
    }

    public void setFecha_esperada(Date fecha_esperada) {
        this.fecha_esperada = fecha_esperada;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

package com.egg.entidades;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pago;

    private Date fecha_pago;

    @Column(length = 255)
    private String forma_pago;

    @Column(length = 255)
    private String id_transaccion;

    private double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Getters y setters
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(String id_transaccion) {
        this.id_transaccion = id_transaccion;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

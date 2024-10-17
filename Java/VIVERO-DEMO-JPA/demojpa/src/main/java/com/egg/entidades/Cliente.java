package com.egg.entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;

    @Column(length = 255)
    private String apellido_contacto;

    @Column(length = 255)
    private String ciudad;

    private int codigo_cliente;

    @Column(length = 255)
    private String codigo_postal;

    @Column(length = 255)
    private String fax;

    private double limite_credito;

    @Column(length = 255)
    private String nombre_cliente;

    @Column(length = 255)
    private String nombre_contacto;

    @Column(length = 255)
    private String pais;

    @Column(length = 255)
    private String region;

    @Column(length = 255)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    // Getters y setters
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getApellido_contacto() {
        return apellido_contacto;
    }

    public void setApellido_contacto(String apellido_contacto) {
        this.apellido_contacto = apellido_contacto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(double limite_credito) {
        this.limite_credito = limite_credito;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}

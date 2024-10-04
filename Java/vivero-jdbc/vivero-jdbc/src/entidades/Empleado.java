package entidades;

public class Empleado {
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String extension;
    private String email;
    private int idOficina;
    private int idJefe;
    private String puesto;

    // Constructor completo
    public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String extension, String email, int idOficina, int idJefe, String puesto) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.extension = extension;
        this.email = email;
        this.idOficina = idOficina;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    // Constructor sin idEmpleado
    public Empleado(String nombreEmpleado, String apellidoEmpleado, String extension, String email, int idOficina, int idJefe, String puesto) {
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.extension = extension;
        this.email = email;
        this.idOficina = idOficina;
        this.idJefe = idJefe;
        this.puesto = puesto;
    }

    // Constructor vacío
    public Empleado() {
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", apellidoEmpleado='" + apellidoEmpleado + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", idOficina=" + idOficina +
                ", idJefe=" + idJefe +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}

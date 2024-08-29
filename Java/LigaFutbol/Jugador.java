package LigaFutbol;

public class Jugador {
    private String nombre;
    private Equipo equipo;

    public Jugador(String nombre,Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo; // Inicialmente no está asignado a ningún equipo
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", equipo=" + (equipo != null ? equipo.getNombre() : "Sin equipo") +
                '}';
    }
}

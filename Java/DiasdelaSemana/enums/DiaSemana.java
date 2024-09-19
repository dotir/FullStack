package DiasdelaSemana.enums;

public enum DiaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;

    public boolean esDiaLaboral() {
        return this != SABADO && this != DOMINGO;
    }
}

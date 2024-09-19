package DiasdelaSemana;

import java.util.Random;

import DiasdelaSemana.enums.DiaSemana;

public class Main {
    public static void main(String[] args) {
        DiaSemana[] dias = generarDiasAleatorios(10);
        for (DiaSemana dia : dias) {
            System.out.println(imprimirDiaLaboral(dia));
        }
    }

    public static DiaSemana[] generarDiasAleatorios(int cantidad) {
        DiaSemana[] dias = new DiaSemana[cantidad];
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int indice = random.nextInt(DiaSemana.values().length);
            dias[i] = DiaSemana.values()[indice];
        }
        return dias;
    }

    public static String imprimirDiaLaboral(DiaSemana dia) {
        if (dia.esDiaLaboral()) {
            return dia + " - Día laboral";
        } else {
            return dia + " - No es día laboral";
        }
    }
    
}

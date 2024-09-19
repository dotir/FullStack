package Excepciones.GestionCuentas;

public class GestionCuentas {
    public static void main(String[] args) {
        
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        try {
            cuenta.retirar(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
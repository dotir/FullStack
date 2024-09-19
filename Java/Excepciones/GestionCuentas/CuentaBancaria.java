package Excepciones.GestionCuentas;

public class CuentaBancaria {
    private double saldoInicial;

    public CuentaBancaria(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }


    public void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldoInicial) {
            throw new SaldoInsuficienteException("No se puede retirar mas de lo que hay en la cuenta");
        }
        saldoInicial -= cantidad;
    }
}
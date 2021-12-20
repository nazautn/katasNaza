package model;

public class Cuenta {
    private Float saldo;

    public Cuenta(Float saldo) {
        this.saldo = saldo;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}

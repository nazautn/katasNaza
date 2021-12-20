public class Cuenta {
    private Float saldo;

    public Cuenta(Float saldo) {
        this.saldo = saldo;
    }

    public void depositar(Float saldoAAgregar) {
        Float saldoNuevo = this.getSaldo() + saldoAAgregar;
        this.setSaldo(saldoNuevo);
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}

import java.util.Date;
import java.util.List;

public class Cuenta {
    private Float saldo;
    private final List<RegistroBalance> balance;

    public static String ENCABEZADO_BALANCE = "Fecha        Monto     Balance";

    public Cuenta(Float saldo) {
        this.saldo = saldo;
        RegistroBalance registro = new RegistroBalance();
        registro.setFecha(new Date());
        registro.setMonto(saldo);
        registro.setBalance(saldo);
        this.balance = List.of(registro);
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

    public void extraer(Float saldoAExtraer) {
        Float saldoNuevo = this.getSaldo() - saldoAExtraer;
        this.setSaldo(saldoNuevo);
    }

    public String getBalanceImprimible() {
        return ENCABEZADO_BALANCE + "\n" + balance.toString();
    }
}

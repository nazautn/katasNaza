import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cuenta {
    private Float saldo;
    private final List<RegistroBalance> balance;

    public static String ENCABEZADO_BALANCE = "Fecha \t Monto \t Balance";

    public Cuenta(Float saldo) {
        this.saldo = saldo;
        this.balance = new ArrayList<>();
        balance.add(new RegistroBalance(new Date(), saldo, saldo));
    }

    public void depositar(Float saldoAAgregar) {
        Float saldoNuevo = this.getSaldo() + saldoAAgregar;
        this.setSaldo(saldoNuevo);
        this.balance.add(new RegistroBalance(new Date(), saldoAAgregar, this.getSaldo()));
    }

    public void extraer(Float saldoAExtraer) {
        Float saldoNuevo = this.getSaldo() - saldoAExtraer;
        this.setSaldo(saldoNuevo);
        this.balance.add(new RegistroBalance(new Date(), -saldoAExtraer, this.getSaldo()));
    }

    public String getBalanceImprimible() {
        return ENCABEZADO_BALANCE + "\n" + imprimir(balance);
    }

    private String imprimir(List<RegistroBalance> balance) {
        StringBuilder resultado = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for(RegistroBalance registro : balance){
            String fechaString = dateFormat.format(registro.getFecha());

            String montoString = registro.getMonto().toString();
            if(registro.getMonto() > 0) {
                montoString = "+" + montoString;
            }

            resultado.append(fechaString).append(" \t ").append(montoString).append(" \t ").append(registro.getBalance()).append("\n");
        }
        return resultado.toString();
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}

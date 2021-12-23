import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroBalance {
    private Date fecha;
    private Float monto;
    private Float balance;

    public RegistroBalance(Date fecha, Float monto, Float balance) {
        this.fecha = fecha;
        this.monto = monto;
        this.balance = balance;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}

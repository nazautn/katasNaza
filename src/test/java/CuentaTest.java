import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class CuentaTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deberiaPoderVerElSaldoDeUnaCuenta() {
        Float saldoInicial = 100F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        Float saldo = cuenta.getSaldo();

        assertEquals(saldo, saldoInicial);
    }

    @Test
    public void deberiaPoderVerElSaldoNegativoDeUnaCuenta() {
        Float saldoInicial = -100F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        Float saldo = cuenta.getSaldo();

        assertEquals(saldo, saldoInicial);
    }

    @Test
    public void deboPoderDepositarEnMiCuentaYRecuperarElSaldoNuevo() {
        Float saldoInicial = 100F;
        Float saldoAAgregar = 50F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        cuenta.depositar(saldoAAgregar);
        Float saldo = cuenta.getSaldo();

        assertThat(saldo).isEqualTo(saldoAAgregar + saldoInicial);
    }

    @Test
    public void deboPoderExtraerDineroDeMieCuentaYRecuperarElSaldoNuervo() {
        Float saldoInicial = 100F;
        Float saldoAExtraer = 50F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        cuenta.extraer(saldoAExtraer);
        Float saldo = cuenta.getSaldo();

        assertThat(saldo).isEqualTo(saldoInicial - saldoAExtraer);
    }

    @Test
    public void deboPoderImprimirElBalanceDeLaCuenta() {
        Float saldoInicial = 100F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        String balance = cuenta.getBalanceImprimible();

        assertThat(balance).contains(Cuenta.ENCABEZADO_BALANCE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String hoy = dateFormat.format(new Date());
        assertThat(balance).contains(String.format("%s \t +100.0 \t 100.0", hoy));
    }

    @Test
    public void luegoDeDepositarSeDebeVerLaActualizacionDelBalance() {
        Float saldoInicial = 100F;
        Cuenta cuenta = new Cuenta(saldoInicial);
        cuenta.depositar(200F);

        String balance = cuenta.getBalanceImprimible();

        assertThat(balance).contains(Cuenta.ENCABEZADO_BALANCE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String hoy = dateFormat.format(new Date());
        assertThat(balance).contains(String.format("%s \t +100.0 \t 100.0", hoy));
        assertThat(balance).contains(String.format("%s \t +200.0 \t 300.0", hoy));
        System.out.println(balance);
    }

    @Test
    public void luegoDeExtraerSeDebeVerLaActualizacionDelBalance() {
        Float saldoInicial = 100F;
        Cuenta cuenta = new Cuenta(saldoInicial);
        cuenta.extraer(200F);

        String balance = cuenta.getBalanceImprimible();

        assertThat(balance).contains(Cuenta.ENCABEZADO_BALANCE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String hoy = dateFormat.format(new Date());
        assertThat(balance).contains(String.format("%s \t +100.0 \t 100.0", hoy));
        assertThat(balance).contains(String.format("%s \t -200.0 \t -100.0", hoy));
        System.out.println(balance);
    }
}

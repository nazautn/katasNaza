import model.Cuenta;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

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
    public void deboPoderDepositarEnMiCuentaYRecuperarElSaldoNuevo(){
        Float saldoInicial = 100F;
        Float saldoAAgregar = 50F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        cuenta.depositar(saldoAAgregar);
        Float saldo = cuenta.getSaldo();

        assertThat(saldo).isEqualTo(saldoAAgregar + saldoInicial);
    }
}

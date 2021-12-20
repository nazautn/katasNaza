import model.Cuenta;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import service.OperatorService;

import static org.junit.Assert.assertEquals;

public class OperatorServiceTest {

    @InjectMocks
    OperatorService operatorService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deberiaPoderVerElSaldoDeUnaCuenta() {
        Float saldoInicial = 100F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        String balance = operatorService.obtenerSaldo(cuenta);

        assertEquals(balance, saldoInicial.toString());
    }

    @Test
    public void deberiaPoderVerElSaldoNegativoDeUnaCuenta() {
        Float saldoInicial = -100F;
        Cuenta cuenta = new Cuenta(saldoInicial);

        String balance = operatorService.obtenerSaldo(cuenta);

        assertEquals(balance, saldoInicial.toString());
    }
}

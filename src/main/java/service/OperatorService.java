package service;

import model.Cuenta;

public class OperatorService {
    public String obtenerSaldo(Cuenta cuenta) {

        return cuenta.getSaldo().toString();
    }
}

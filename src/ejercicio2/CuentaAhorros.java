
package ejercicio2;

/**
 *
 * @author ycassiani
 */
public class CuentaAhorros extends Cuenta{
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        if (saldo < 10000) {
            activa = false;
        } else {
            activa = true;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
            if (saldo >= 10000 && !activa) {
                activa = true;
            }
        } else {
            System.out.println("La cuenta de ahorros está inactiva.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
            if (saldo < 10000 && activa) {
                activa = false;
            }
            if (numRetiros > 4) {
                comisionMensual += (numRetiros - 4) * 1000;
            }
        } else {
            System.out.println("La cuenta de ahorros está inactiva.");
        }
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        if (saldo < 10000 && activa) {
            activa = false;
        }
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Activa: " + activa);
    }
}


package ejercicio2;

/**
 *
 * @author ycassiani
 */
public class CuentaCorriente extends Cuenta{
    private float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    public void retirar(float cantidad) {
        if (cantidad <= getSaldo() + sobregiro) {
            if (cantidad <= getSaldo()) {
                setSaldo(getSaldo() - cantidad);
            } else {
                sobregiro = sobregiro + getSaldo() - cantidad;
                setSaldo(0);
            }
        } else {
            System.out.println("No es posible realizar el retiro. La cantidad es mayor al saldo y sobregiro.");
        }
    }

    public void consignar(float cantidad) {
        super.consignar(cantidad);
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                setSaldo(getSaldo() + cantidad - sobregiro);
                sobregiro = 0;
            } else {
                sobregiro = sobregiro - cantidad;
            }
        }
    }

    public void extractoMensual() {
        if (getNumRetiros() > 4) {
            setComisionMensual((getNumRetiros() - 4) * 1000);
        } else {
            setComisionMensual(0);
        }
        if (getSaldo() + sobregiro < 0) {
            setComisionMensual(getComisionMensual() + 5000);
        }
        calcularInteres();
        setSaldo(getSaldo() - getComisionMensual());
    }

    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comisión mensual: " + getComisionMensual());
        System.out.println("Número de transacciones: " + (getNumConsignaciones() + getNumRetiros()));
        System.out.println("Sobregiro: " + sobregiro);
    }
}

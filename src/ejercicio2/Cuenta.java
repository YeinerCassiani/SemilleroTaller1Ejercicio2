
package ejercicio2;

/**
 *
 * @author ycassiani
 */
public class Cuenta {
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float cantidad) {
        saldo += cantidad;
        numConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void calcularInteres() {
        float interesMensual = saldo * tasaAnual / 12 / 100;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
    }

    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println("Número de transacciones: " + (numConsignaciones + numRetiros));        
        comisionMensual = 0;
        numConsignaciones = 0;
        numRetiros = 0;
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNumConsignaciones() {
        return numConsignaciones;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setNumConsignaciones(int numConsignaciones) {
        this.numConsignaciones = numConsignaciones;
    }

    public void setNumRetiros(int numRetiros) {
        this.numRetiros = numRetiros;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
    
    
}

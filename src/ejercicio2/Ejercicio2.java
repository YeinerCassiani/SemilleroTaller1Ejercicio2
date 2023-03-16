
package ejercicio2;

/**
 *
 * @author ycassiani
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CuentaAhorros miCuenta = new CuentaAhorros(100000, 5);
        miCuenta.consignar(1000); 
        miCuenta.retirar(500); 
        miCuenta.retirar(600); 
        miCuenta.retirar(500); 
        miCuenta.retirar(600); 
        miCuenta.retirar(500); 
        miCuenta.retirar(600); 
        miCuenta.consignar(15000); 
        miCuenta.extractoMensual(); 
        miCuenta.imprimir(); 
    }
    
}

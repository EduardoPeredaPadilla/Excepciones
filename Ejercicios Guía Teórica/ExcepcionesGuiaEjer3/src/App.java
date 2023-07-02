import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);

        /*System.out.println("Ingrese un número");
        String numSt1 = scan.next();
        System.out.println("Ingrese otro número");
        String numSt2 = scan.next();

        int numM1 = Integer.parseInt(numSt1);
        int numM2 = Integer.parseInt(numSt2);

        double div = numM1 / numM2;
        System.out.println("El resultado de la división es " + div);*/
        
        
        System.out.println("");
        System.out.println("Primer Try Catch");
        try {
            System.out.println("Ingrese un número");
            int numSt1 = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Dentro del primer catch");
            System.out.println(e.toString());
        }
        System.out.println("");
        System.out.println("Segundo Try Catch");
        
        try {
            int numero = Integer.parseInt("Palabra a números");
        } catch (NumberFormatException e) {
            System.out.println("Dentro del segundo catch");
            System.out.println(e.toString());
        }
        System.out.println("");
        System.out.println("Tercer Try Catch");
        try {
            System.out.println("Vamos a dividir 20 / 0");
            int div = 20/0;
        } catch (ArithmeticException e) {
            System.out.println("Dentro del tercer catch");
            System.out.println(e.toString());
        }


    }
}

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Random random = new Random();
        System.out.println("----------- JUEGO ADIVINA EL NÚMERO -------------");
        int secretNum = random.nextInt(500) + 1;
        System.out.println("Número secreto = " + secretNum);
        int intentos = 0;
        juego(secretNum, intentos);

    }



    public static void juego(int secretNum, int intentos){
        
        Scanner scan = new Scanner(System.in);

        Integer userNum = 0;

        System.out.println("Ingresa el número para ver si es el número secreto");
        try {
            userNum = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Dentro del catch");
            System.out.println("Dato inválido, debes ingresar un número entero");
            intentos++;
            //scan.nextLine(); // Limpiar el búfer del escáner
            juego(secretNum, intentos);
            scan.close();
            return; // Agregar esta línea para finalizar el método
        }

        if (secretNum < userNum) {
            System.out.println("El número secreto es menor al ingresado, intenta nuevamente");
            intentos++;
            juego(secretNum, intentos);
        } else if (secretNum > userNum) {
            System.out.println("El número secreto es mayor al ingresado, intenta nuevamente");
            intentos++;
            juego(secretNum, intentos);
        } else if (secretNum == userNum) {
            intentos++;
            System.out.println("¡Adivinaste!");
            System.out.println("El número secreto es " + secretNum);
            System.out.println("Número de intentos = " + intentos);
        }

        scan.close();
    }
}

package Services;

import java.util.Scanner;

import Entidades.Persona;

public class PersonaService {
    
    //Scanner scan = new Scanner(System.in).useDelimiter("\n");

    Scanner scan = new Scanner(System.in);

    public Persona crearPersona() {
        
        Persona pers = new Persona();
        System.out.println("Ingrese el nombre de la persona");
        pers.setNombre(scan.next());
        System.out.println("Ingrese la edad de la persona");
        int edad = scan.nextInt();
        pers.setEdad(edad);
        String sex;
        do {
            System.out.println("Ingrese el seco de la persona");
            System.out.println("(H) Hombre");
            System.out.println("(M) Mujer");
            System.out.println("(O) Otrop");
            sex = scan.next();
            if (!sex.equalsIgnoreCase("H") && !sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("O")) {
                System.out.println("Opción inválida");
            }
        } while (!sex.equalsIgnoreCase("H") && !sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("O"));
        pers.setSexo(sex);
        System.out.println("Ingrese el peso de la persona");
        pers.setPeso(scan.nextFloat());
        System.out.println("Ingrese la altura de la persona");
        pers.setAltura(scan.nextFloat());
        return pers;
    }
    
    public int calcularIMC(Persona pers) {
        
        int PI = 0;
        //System.out.println("altura = " + pers.getAltura());
        //float pesoIdeal = (float) (pers.getAltura() * pers.getAltura());
        //System.out.println("altura al cuadrado " + pesoIdeal);
        float pesoIdeal = pers.getPeso() / (pers.getAltura() * pers.getAltura());
        pesoIdeal = roundToTwoDecimals(pesoIdeal);
        //System.out.println(pesoIdeal);
        if (pesoIdeal < 20) {
            PI = -1;
            System.out.println("Resultado Peso Ideal " + PI);
            return PI;
        } else if (pesoIdeal >= 20 && pesoIdeal <= 25) {
            PI = 0;
            System.out.println("Resultado Peso Ideal " + PI);
            return PI;
        } else if (pesoIdeal > 25) {
            PI = 1;
            System.out.println("Resultado Peso Ideal " + PI);
            return PI;
        }
        
        return PI;
    }
    
    public static float roundToTwoDecimals(float pesoIdeal) {
        return (float) (Math.round(pesoIdeal * 100.0) / 100.0);
    }
    
    public boolean esMayorDeEdad(Persona pers) {
        
        boolean esMayor;
        if (pers.getEdad() >= 18) {
            esMayor = true;
        } else {
            esMayor = false;
        }
        System.out.println("La persona es mayor de edad = " + esMayor);
        
        return esMayor;
    }

}

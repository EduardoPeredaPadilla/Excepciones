

import java.util.Scanner;

import Entidades.Armadura;
import Services.ArmaduraService;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArmaduraService armServ = new ArmaduraService();
        Armadura armadura = armServ.nuevaArmadura();
        
        System.out.println("");
        System.out.println("------------ ARMADURA IRONMAN -----------------");
        armServ.mostrarArmadura(armadura); 
        System.out.println("");
        
        System.out.println("Bienvenido, soy JARVIS");
        
        System.out.println("Menú de opciones");
        System.out.println("1. Caminar");
        System.out.println("2.Correr");
        System.out.println("3. Propulsar");
        System.out.println("4. Volar");
        System.out.println("5. Disparar");
        System.out.println("6. Reparar");
        System.out.println("7. Salir");
        Menu(armadura);

        /*int tiempo = 1;
        System.out.println("");
        System.out.println("El tiempo en minutos = " + tiempo);
        System.out.println("------------ Estatus Armatura después de caminar -------------");
        armServ.caminarArm(armadura, tiempo);
        armServ.mostrarArmadura(armadura); 
        System.out.println("");
        System.out.println("------------ Estatus Armatura después de correr -------------");
        armServ.correrArm(armadura, tiempo);
        armServ.mostrarArmadura(armadura); 
        System.out.println("");
        System.out.println("------------ Estatus Armatura después de propulsarse -------------");
        armServ.propulsarArm(armadura, tiempo);
        armServ.mostrarArmadura(armadura); 
        System.out.println("");
        System.out.println("------------ Estatus Armatura después de volar -------------");
        armServ.volarArm(armadura, tiempo);
        armServ.mostrarArmadura(armadura); 
        System.out.println("");
        System.out.println("------------ Estatus Armatura después de disparar -------------");
        armServ.dispararArm(armadura, tiempo);
        armServ.mostrarArmadura(armadura); 
        System.out.println("");
        System.out.println("------------ Estatus Armatura después de escribir en la consola -------------");
        armServ.escribirConsola(armadura, tiempo);
        armServ.mostrarArmadura(armadura); 
        System.out.println("");
        System.out.println("------------ Estatus Armatura después de hablar por el sintetizador -------------");
        armServ.hablarSint(armadura, tiempo);
        armServ.mostrarArmadura(armadura); 
        System.out.println("");*/

    }

    public static void Menu(Armadura armadura) {

        ArmaduraService armServ = new ArmaduraService();
        Scanner scan = new Scanner(System.in);

        
        int opMenu = scan.nextInt();
        int tiempo;

        while (opMenu != 7) {
            
            switch (opMenu) {
                case 1:
                    System.out.println("Opción 1. Caminar");
                    System.out.println("Ingresa el tiempo (número entero)");
                    tiempo = scan.nextInt();
                    armServ.caminarArm(armadura, tiempo);
                    System.out.println("------------ Estatus Armatura después de caminar -------------");
                    armServ.mostrarArmadura(armadura); 
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Opción 2. Correr");
                    System.out.println("Ingresa el tiempo (número entero)");
                    tiempo = scan.nextInt();
                    System.out.println("------------ Estatus Armatura después de correr -------------");
                    armServ.mostrarArmadura(armadura); 
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("Opción 7. Salir");
                    System.out.println("Hasta pronto!");
                    scan.close();
                    return;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println("Menú de opciones");
            System.out.println("1. Caminar");
            System.out.println("2.Correr");
            System.out.println("3. Propulsar");
            System.out.println("4. Volar");
            System.out.println("5. Disparar");
            System.out.println("6. Reparar");
            System.out.println("7. Salir");
            opMenu = scan.nextInt();
        }
        scan.close();
    }
}

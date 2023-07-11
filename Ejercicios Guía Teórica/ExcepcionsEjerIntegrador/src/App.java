import java.util.InputMismatchException;
import java.util.Scanner;

import Entidades.Armadura;
import Services.ArmService;
import Execpciones.DamageDeviceException;
import Execpciones.DestroyedDeviceException;
import Execpciones.EnergiaInsuficienteException;

public class App {

    
    public static void main(String[] args) throws EnergiaInsuficienteException, InputMismatchException, DamageDeviceException, DestroyedDeviceException {
        
        ArmService armServ = new ArmService();
        Armadura arm = new Armadura();
        arm = armServ.crearArmadura();
        menu(arm);
    }

    public static void menu(Armadura arm) throws EnergiaInsuficienteException, InputMismatchException, DamageDeviceException, DestroyedDeviceException {

        int opMenu = 0;
        ArmService armServ = new ArmService();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("Menú de acciones");
            System.out.println("1. Mostrar estatus de armadura");
            System.out.println("2. Caminar");
            System.out.println("3. Correr");
            System.out.println("4. Propulsar");
            System.out.println("5. Volar");
            System.out.println("6. Disparar");
            System.out.println("7. Recibir mensaje por Consola");
            System.out.println("8. Recibir mensaje por Sintetizador");
            System.out.println("9. Usar Radar para buscar Objetos Voladores");
            System.out.println("10. Mostrar Objetos Voladores Hostiles");
            System.out.println("11. Revisar el Estado de la Armadura por Dispositivo");
            System.out.println("12. Alejarse para incrementar Energía *");
            System.out.println("13. Salir");
            System.out.println("");
            System.out.println("Elige una opción");
            try {
                opMenu = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Dato inválido");
                menu(arm);
                return;
            }
            switch (opMenu) {
                case 1:
                    System.out.println("*Estatus de Armadura");
                    System.out.println(arm.toString());
                    break;
                case 2:
                    try {
                        armServ.caminar(arm);
                        //System.out.println(arm.toString());
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        armServ.correr(arm);
                        //System.out.println(arm.toString());
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        armServ.propulsar(arm);
                        //System.out.println(arm.toString());
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        armServ.volar(arm);
                        //System.out.println(arm.toString());
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        armServ.disparar(arm);
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        armServ.escribirJARVIS(arm);
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        armServ.hablarJARVIS(arm);
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        armServ.usarRadar(arm);
                    } catch (EnergiaInsuficienteException e) {
                        System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Respuesta inválida");
                    }
                    break;
                case 10:
                    try {
                        armServ.mostrarObjVolHostiles(arm);
                    } catch (EnergiaInsuficienteException e) {
                            System.out.println(e.getMessage());
                    } catch (DamageDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Respuesta inválida");
                    }
                    break;
                case 11:
                    try {
                        armServ.revisarEstadoArmadura(arm);
                    } catch (InputMismatchException e) {
                        System.out.println("Dato de respuesta inválido desde Service");
                    } catch (DestroyedDeviceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    arm.setEnergia((int)arm.getEnergiaMaxima());
                    arm.setReactor(arm.getEnergiaMaxima());
                    arm.setBateria(100.0);
                    break;
                case 13:
                    System.out.println("Armadura Desactivada");
                    break;
                default:
                    System.out.println("Opción fuera del rango del menú");
                    scan.close();
                    break;
            }

        } while ( opMenu != 13);
        scan.close();

    }
}

package Services;

import java.util.ArrayList;
import java.util.Random;

import Entidades.Bota;

public class BotaService {
    
    Random random = new Random();
    public ArrayList<Bota> botas = new ArrayList<>();
    
    public ArrayList<Bota> addBotas(ArrayList<Bota> botas) {

        Bota botaIz = new Bota("Propulsor Bota Izquierda");
        botaIz.setConsumo(10);
        botas.add(botaIz);
        Bota botaDe = new Bota("Propulsor Bota Derecha");
        botaDe.setConsumo(10);
        botas.add(botaDe);

        return botas;
    }

    public Integer caminarBotas(ArrayList<Bota> botas, int tiempo) {

        Integer consumoEnergia = 0;
        for (Bota bota : botas) {
            if (bota.getDamage() == true) {
                System.out.println("El dispositivo " + bota.getOrientacion() + " se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
            consumoEnergia = consumoEnergia + bota.caminar(bota, tiempo);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                bota.setDamage(true);
                System.out.println(" + Alerta!!!");
                System.out.println("   + Dispositivo Dañado");
            }
        }
        return consumoEnergia;
    }

    public Integer correrBotas(ArrayList<Bota> botas, int tiempo) {

        Integer consumoEnergia = 0;
        for (Bota bota : botas) {
            if (bota.getDamage() == true) {
                System.out.println("El dispositivo " + bota.getOrientacion() + " se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
            consumoEnergia = consumoEnergia + bota.correr(bota, tiempo);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                bota.setDamage(true);
                System.out.println(" + Alerta!!!");
                System.out.println("   + Dispositivo Dañado");
            }
        }
        return consumoEnergia;
    }

    public Integer propulsarBotas(ArrayList<Bota> botas, int tiempo) {

        Integer consumoEnergia = 0;
        for (Bota bota : botas) {
            if (bota.getDamage() == true) {
                System.out.println("El dispositivo " + bota.getOrientacion() + " se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
            consumoEnergia = consumoEnergia + bota.propulsar(bota, tiempo);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                bota.setDamage(true);
                System.out.println(" + Alerta!!!");
                System.out.println("   + Dispositivo Dañado");
            }
        }
        return consumoEnergia;
    }

    public Integer volarBotas(ArrayList<Bota> botas, int tiempo) {

        Integer consumoEnergia = 0;
        for (Bota bota : botas) {
            if (bota.getDamage() == true) {
                System.out.println("El dispositivo " + bota.getOrientacion() + " se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
            consumoEnergia = consumoEnergia + bota.volarB(bota, tiempo);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                bota.setDamage(true);
                System.out.println(" + Alerta!!!");
                System.out.println("   + Dispositivo Dañado");
            }
        }
        return consumoEnergia;
    }

    public void repararBotas(ArrayList<Bota> botas) {

        for (Bota bota : botas) {
            int proReparar = random.nextInt(10) + 1;
            if (proReparar <= 4) {
                bota.setDamage(false);
                System.out.println("Dispositivo "+ bota.getOrientacion() + " reparado, Disp.Dañado = " + bota.getDamage());
            } else{
                if (bota.getDamage() == true) {
                    System.out.println("El dispositivo " + bota.getOrientacion() + " no se pudo reparar");
                }
                
            }
        }
    }

}

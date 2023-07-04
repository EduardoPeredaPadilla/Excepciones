package Services;

import java.util.ArrayList;
import java.util.Random;

import Entidades.Guante;

public class GuanteService {
    
    Random random = new Random();
    public ArrayList<Guante> guantes = new ArrayList<>();

    public ArrayList<Guante> addGuantes(ArrayList<Guante> guantes) {

        Guante guanteIz = new Guante("Repulsor Guante Izquierdo");
        guanteIz.setConsumo(5);
        guantes.add(guanteIz);
        Guante guanteDe = new Guante("Repulsor Guante Derecho");
        guanteDe.setConsumo(5);
        guantes.add(guanteDe);

        return guantes;
    }

    public Integer volarGuantes(ArrayList<Guante> guantes, int tiempo) {

        Integer consumoEnergia = 0;
        for (Guante guante : guantes) {
            if (guante.getDamage() == true) {
                System.out.println("El dispositivo " + guante.getOrientacion() + " se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
            consumoEnergia = consumoEnergia + guante.volarG(guante, tiempo);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                guante.setDamage(true);
                System.out.println(" + Alerta!!!");
                System.out.println("   + Dispositivo Dañado");
            }
        }
        return consumoEnergia;
    }

    public Integer dispararGuantes(ArrayList<Guante> guantes, int tiempo) {

        Integer consumoEnergia = 0;
        for (Guante guante : guantes) {
            if (guante.getDamage() == true) {
                System.out.println("El dispositivo " + guante.getOrientacion() + " se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
            consumoEnergia = consumoEnergia + guante.disparar(guante, tiempo);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                guante.setDamage(true);
                System.out.println(" + Alerta!!!");
                System.out.println("   + Dispositivo Dañado");
            }
        }
        return consumoEnergia;
    }

    public void repararGuantes(ArrayList<Guante> guantes) {

        for (Guante guante : guantes) {
            int probReparar = random.nextInt(10) + 1;
            if (probReparar <= 4) {
                guante.setDamage(false);
                System.out.println("Dispositivo "+ guante.getOrientacion() + " reparado, Disp.Dañado = " + guante.getDamage());    
            } else {
                if (guante.getDamage() == true) {
                    System.out.println("El dispositivo " + guante.getOrientacion() + " no se pudo reparar");
                }
                
            }
        }
    }
}

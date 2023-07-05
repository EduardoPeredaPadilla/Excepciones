package Services;

import java.util.Random;

import Entidades.Consola;

public class ConsolaService {
    
    Random random = new Random();

    public Consola addConsola() {

        Consola consola = new Consola();
        consola.setConsumo(15);

        return consola;
    }

    public boolean repararConsola(Consola consola) {

        boolean reparado = true;
        int proReparar = random.nextInt(10) + 1;
        if (proReparar <= 4) {
            consola.setDamage(false);
            System.out.println("Dispositivo Consola reparado, Dip.Damage = " + consola.getDamage());
            reparado = true;
            return reparado;
        } else {
            System.out.println("El dispositivo no se pudo reparar");
            reparado = false;
            return reparado;
        }
    }

}

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

    

}

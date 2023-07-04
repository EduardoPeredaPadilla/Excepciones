package Services;

import java.util.Random;

import Entidades.Sintetizador;

public class SintService {
    
    Random random = new Random();

    public Sintetizador addSintetizador() {

        Sintetizador sint = new Sintetizador();
        sint.setConsumo(15);

        return sint;
    }

}

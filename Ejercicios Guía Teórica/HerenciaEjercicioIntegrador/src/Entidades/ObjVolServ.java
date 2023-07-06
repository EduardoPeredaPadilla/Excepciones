package Entidades;

import java.util.Random;

public class ObjVolServ {
    
    Random random = new Random();
    

    public ObjetoVolador agregarObjeto(){

        ObjetoVolador obVol = new ObjetoVolador();
        int auxHostil = random.nextInt(2) + 1;
        if (auxHostil == 1) {
            obVol.setHostil(true);
        } else {
            obVol.setHostil(true);
        }

        Integer resistencia = random.nextInt(500) + 100;
        obVol.setResistencia(resistencia);

        Integer[] coordenadas = new Integer[3];

        for (int i = 0; i < 3; i++) {
            Integer valorEje = random.nextInt(100) + 10;
            coordenadas[i] = valorEje;
        }

        obVol.setCoordenadas(coordenadas);
        
        return obVol;
    }

}

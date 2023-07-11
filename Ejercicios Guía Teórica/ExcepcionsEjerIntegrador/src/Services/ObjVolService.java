package Services;

import java.util.Random;

import Entidades.ObjetoVolador;
import Enum.Estado;

public class ObjVolService {
    
    public ObjetoVolador agregarObjetoVolador() {

        Random random = new Random();

        ObjetoVolador obVol = new ObjetoVolador();
        int auxHostil = random.nextInt(2) + 1;
        if (auxHostil == 1) {
            obVol.setHostil(true);
        } else {
            obVol.setHostil(false);
        }

        int resistencia = random.nextInt(500) + 100;
        obVol.setResistencia(resistencia);

        int[] coordenadas = new int[3];

        for (int i = 0; i < 3; i++) {
            int valorEje = random.nextInt(100) + 10;
            coordenadas[i] = valorEje;
        }

        obVol.setCoordenadas(coordenadas);

        obVol.setEstado(Estado.OPTIMO);
        
        return obVol;
    }
        
    

}

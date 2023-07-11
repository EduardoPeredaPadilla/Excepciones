package Interfaz;

import Execpciones.DestroyedDeviceException;

public interface Arreglar {
    
    public boolean arreglarDispositivo(int prob) throws DestroyedDeviceException;
}

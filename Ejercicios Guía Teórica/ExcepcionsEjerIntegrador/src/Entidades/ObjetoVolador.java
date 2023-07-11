package Entidades;

import Enum.Estado;

public class ObjetoVolador {
    
    private boolean hostil;
    private int resistencia;
    private int[] coordenadas = new int[3];
    private Estado estado;


    public ObjetoVolador() {
    }

    public ObjetoVolador(boolean hostil, int resistencia, int[] coordenadas) {
        this.hostil = hostil;
        this.resistencia = resistencia;
        this.coordenadas = coordenadas;
    }


    public ObjetoVolador(boolean hostil, int resistencia, int[] coordenadas, Estado estado) {
        this.hostil = hostil;
        this.resistencia = resistencia;
        this.coordenadas = coordenadas;
        this.estado = estado;
    }


    public boolean isHostil() {
        return this.hostil;
    }

    public boolean getHostil() {
        return this.hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }

    public int getResistencia() {
        return this.resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int[] getCoordenadas() {
        return this.coordenadas;
    }

    public int getCoordenadas(int i) {
        return coordenadas[i];
    }

    public void setCoordenadas(int[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



    @Override
    public String toString() {
        return "{" +
            " Hostil = " + isHostil() +
            " Resistencia = " + getResistencia() +
            " Coordenadas = [" + getCoordenadas(0) + ", " + getCoordenadas(1) + ", " + getCoordenadas(2)  + "]"+ 
            " Estado = " + getEstado() + "}";
    }

}

package Entidades;

public class ObjetoVolador {
    
    private boolean hostil;
    private Integer resistencia;
    private Integer[] coordenadas = new Integer[3];


    public ObjetoVolador() {
    }

    public ObjetoVolador(boolean hostil, Integer resistencia, Integer[] coordenadas) {
        this.hostil = hostil;
        this.resistencia = resistencia;
        this.coordenadas = coordenadas;
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

    public Integer getResistencia() {
        return this.resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Integer[] getCoordenadas() {
        return this.coordenadas;
    }

    public void setCoordenadas(Integer[] coordenadas) {
        this.coordenadas = coordenadas;
    }


    @Override
    public String toString() {
        return "{" +
            " hostil='" + isHostil() + "'" +
            ", resistencia='" + getResistencia() + "'" +
            ", coordenadas='" + getCoordenadas() + "'" +
            "}";
    }

    

}

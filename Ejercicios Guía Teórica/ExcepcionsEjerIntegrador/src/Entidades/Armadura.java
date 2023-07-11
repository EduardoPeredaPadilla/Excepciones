package Entidades;



public class Armadura {
    
    private String colorPrimario;
    private String colorSecundario;
    private int resistencia;
    private int energia;
    private double reactor;
    private Bota botaIzq;
    private Bota botaDer;
    private Guante guanteIzq;
    private Guante guanteDer;
    private Casco casco;
    private double bateria;
    private double energiaMaxima;
    private Radar radar;


    public Armadura() {
    }



    public Armadura(String colorPrimario, String colorSecundario, int resistencia, int energia, double reactor, Bota botaIzq, Bota botaDer, Guante guanteIzq, Guante guanteDer, Casco casco, double bateria, double energiaMaxima, Radar radar) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.resistencia = resistencia;
        this.energia = energia;
        this.reactor = reactor;
        this.botaIzq = botaIzq;
        this.botaDer = botaDer;
        this.guanteIzq = guanteIzq;
        this.guanteDer = guanteDer;
        this.casco = casco;
        this.bateria = bateria;
        this.energiaMaxima = energiaMaxima;
        this.radar = radar;
    }
 
    

    public String getColorPrimario() {
        return this.colorPrimario;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public String getColorSecundario() {
        return this.colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public int getResistencia() {
        return this.resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public double getReactor() {
        return this.reactor;
    }

    public void setReactor(double reactor) {
        this.reactor = reactor;
    }

    public Bota getBotaIzq() {
        return this.botaIzq;
    }

    public void setBotaIzq(Bota botaIzq) {
        this.botaIzq = botaIzq;
    }

    public Bota getBotaDer() {
        return this.botaDer;
    }

    public void setBotaDer(Bota botaDer) {
        this.botaDer = botaDer;
    }

    public Guante getGuanteIzq() {
        return this.guanteIzq;
    }

    public void setGuanteIzq(Guante guanteIzq) {
        this.guanteIzq = guanteIzq;
    }

    public Guante getGuanteDer() {
        return this.guanteDer;
    }

    public void setGuanteDer(Guante guanteDer) {
        this.guanteDer = guanteDer;
    }


    public Casco getCasco() {
        return this.casco;
    }

    public void setCasco(Casco casco) {
        this.casco = casco;
    }
    

    public double getBateria() {
        return this.bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }



    public double getEnergiaMaxima() {
        return this.energiaMaxima;
    }

    public void setEnergiaMaxima(double energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }

    public Radar getRadar() {
        return this.radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }


    @Override
    public String toString() {
        return 
            " \n Color Primario = " + getColorPrimario() +
            " \n Color Secundario = " + getColorSecundario() +
            " \n Resistencia = " + getResistencia() +
            " \n Batería = " + getBateria() + "%" +
            " \n Energia = " + getEnergia() +
            " \n Reactor = " + getReactor() +
            " \n BotaIzq = " + getBotaIzq() +
            " \n BotaDer = " + getBotaDer() +
            " \n GuanteIzq = " + getGuanteIzq() +
            " \n GuanteDer = " + getGuanteDer() +
            " \n Casco = " + getCasco() +
            " \n Radar = " + getRadar();
    }

    

}

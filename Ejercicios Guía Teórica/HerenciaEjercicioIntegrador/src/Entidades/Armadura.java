package Entidades;

import java.util.ArrayList;


public class Armadura {
    
    protected String colorPrimario;
    protected String colorSecundario;

    protected ArrayList<Bota> botas = new ArrayList<>();

    protected ArrayList<Guante> guantes = new ArrayList<>();

    protected String material;
    protected Integer resistencia;

    protected Integer salud;
    protected Integer energia;

    protected Integer energiaMax;
    
    protected float bateria;
    protected float reactor;

    protected Consola consola;
    protected Sintetizador sint;

    
    

    public Armadura() {
    }


    public Armadura(String colorPrimario, String colorSecundario, ArrayList<Bota> botas, ArrayList<Guante> guantes, String material, Integer resistencia, Integer salud, Integer energia, float bateria, float reactor, Consola consola, Sintetizador sint) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.botas = botas;
        this.guantes = guantes;
        this.material = material;
        this.resistencia = resistencia;
        this.salud = salud;
        this.energia = energia;
        this.bateria = bateria;
        this.reactor = reactor;
        this.consola = consola;
        this.sint = sint;
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


    public ArrayList<Bota> getBotas() {
        return this.botas;
    }

    public void setBotas(ArrayList<Bota> botas) {
        this.botas = botas;
    }
    

    public ArrayList<Guante> getGuantes() {
        return this.guantes;
    }

    public void setGuantes(ArrayList<Guante> guantes) {
        this.guantes = guantes;
    }  
    

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getResistencia() {
        return this.resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Integer getSalud() {
        return this.salud;
    }

    public void setSalud(Integer salud) {
        this.salud = salud;
    }

    public Integer getEnergia() {
        return this.energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }


    public Integer getEnergiaMax() {
        return this.energiaMax;
    }

    public void setEnergiaMax(Integer energiaMax) {
        this.energiaMax = energiaMax;
    }


    public float getBateria() {
        return this.bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = bateria;
    }


    public float getReactor() {
        return this.reactor;
    }

    public void setReactor(float reactor) {
        this.reactor = reactor;
    }


    public Consola getConsola() {
        return this.consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    public Sintetizador getSint() {
        return this.sint;
    }

    public void setSint(Sintetizador sint) {
        this.sint = sint;
    }

    

    @Override
    public String toString() {
        return "Armadura " +
            " \n Color Primario = " + getColorPrimario() +
            " \n Color Secundario = " + getColorSecundario() +
            " \n Botas = " + getBotas()  +
            " \n Guantes = " + getGuantes() +
            " \n Material = " + getMaterial()  +
            " \n Resistencia = " + getResistencia()  +
            " \n Salud = " + getSalud()  +
            " \n Energia = " + getEnergia() +
            " \n Bateria = " + getBateria()+ "%" +
            " \n Reactor = " + getReactor() +
            " \n Consola = " + getConsola() +
            " \n Sintetizador = " + getSint();
    }

}

package Entidades;

import Enum.Estado;
import java.util.Objects;

public class Casco {
    
    private Estado estado;
    private int consumoE;
    private Consola consola;
    private Sintetizador sint;

    public Casco() {
    }

    public Casco(Estado estado, int consumoE, Consola consola, Sintetizador sint) {
        this.estado = estado;
        this.consumoE = consumoE;
        this.consola = consola;
        this.sint = sint;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getConsumoE() {
        return this.consumoE;
    }

    public void setConsumoE(int consumoE) {
        this.consumoE = consumoE;
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

    public Casco estado(Estado estado) {
        setEstado(estado);
        return this;
    }

    public Casco consumoE(int consumoE) {
        setConsumoE(consumoE);
        return this;
    }

    public Casco consola(Consola consola) {
        setConsola(consola);
        return this;
    }

    public Casco sint(Sintetizador sint) {
        setSint(sint);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Casco)) {
            return false;
        }
        Casco casco = (Casco) o;
        return Objects.equals(estado, casco.estado) && consumoE == casco.consumoE && Objects.equals(consola, casco.consola) && Objects.equals(sint, casco.sint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado, consumoE, consola, sint);
    }

    @Override
    public String toString() {
        return "{" +
            " Estado = " + getEstado() +
            ", ConsumoE = " + getConsumoE() +
            ", Consola = " + getConsola() +
            ", Sintetizador = " + getSint() + "}";
    }
    

}

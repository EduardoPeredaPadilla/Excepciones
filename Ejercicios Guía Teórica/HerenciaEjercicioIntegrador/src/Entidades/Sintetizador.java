package Entidades;

import java.util.Random;

public class Sintetizador {
    
    private Integer consumo;
    public boolean damage;


    public Sintetizador() {
    }


    public Sintetizador(Integer consumo, boolean damage) {
        this.consumo = consumo;
        this.damage = damage;
    }

    public Integer getConsumo() {
        return this.consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public boolean isDamage() {
        return this.damage;
    }

    public boolean getDamage() {
        return this.damage;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
    }

    public Integer hablar(Sintetizador sint, int tiempo) {
        Random random = new Random();
        Integer consumoEnergia = 0;
        if (sint.getDamage() == true) {
                System.out.println("El dispositivo Consola se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
        consumoEnergia = sint.getConsumo() * tiempo;
        int probDamage = random.nextInt(10) + 1;
        if (probDamage <= 3) {
            sint.setDamage(true);
        }
        return consumoEnergia;
    }

    @Override
    public String toString() {
        return "{" +
            " Consumo = " + getConsumo() +
            ", Damage = " + isDamage() +
            "}";
    }

}

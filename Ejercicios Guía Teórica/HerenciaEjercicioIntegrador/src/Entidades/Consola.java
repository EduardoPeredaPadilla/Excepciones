package Entidades;

import java.util.Random;

public class Consola {
    
    private Integer consumo;
    public boolean damage;


    public Consola() {
    }


    public Consola(Integer consumo, boolean damage) {
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

    public Integer escribir(Consola consola, int tiempo) {
        Random random = new Random();
        Integer consumoEnergia = 0;
        if (consola.getDamage() == true) {
                System.out.println("El dispositivo Consola se encuentra dañado y no se puede utilizar");
                return consumoEnergia;
            }
        consumoEnergia = consola.getConsumo() * tiempo;
        int probDamage = random.nextInt(10) + 1;
        if (probDamage <= 3) {
            consola.setDamage(true);
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

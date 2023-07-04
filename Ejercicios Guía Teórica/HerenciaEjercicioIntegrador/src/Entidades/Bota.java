package Entidades;


public class Bota {
    
    private String orientacion;
    private Integer consumo;
    public boolean damage;


    public Bota() {
    }

    public Bota(String orientacion) {
        this.orientacion = orientacion;
    }

    public Bota(String orientacion, Integer consumo, boolean damage) {
        this.orientacion = orientacion;
        this.consumo = consumo;
        this.damage = damage;
    }

    public String getOrientacion() {
        return this.orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
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

    public Integer caminar(Bota bota, int tiempo) {
        
        Integer consumoEnergia = 0;;
            
            consumoEnergia = consumoEnergia + (bota.getConsumo() * tiempo);

        return consumoEnergia;
    }

    public Integer correr(Bota bota, int tiempo) {
        
        Integer consumoEnergia = 0;;   
        consumoEnergia = consumoEnergia + ((bota.getConsumo()*2) * tiempo);
        return consumoEnergia;
    }

    public Integer propulsar(Bota bota, int tiempo) {
        
        Integer consumoEnergia = 0;;
        consumoEnergia = consumoEnergia + ((bota.getConsumo()*3) * tiempo);
        return consumoEnergia;
    }

    public Integer volarB(Bota bota, int tiempo) {
        
        Integer consumoEnergia = 0;;        
        consumoEnergia = consumoEnergia + ((bota.getConsumo()*3) * tiempo);
        return consumoEnergia;
    }


    @Override
    public String toString() {
        return "{" +
            " Orientacion = " + getOrientacion() +
            ", Consumo = " + getConsumo() +
            ", Damage = " + isDamage() +
            "}";
    }





}

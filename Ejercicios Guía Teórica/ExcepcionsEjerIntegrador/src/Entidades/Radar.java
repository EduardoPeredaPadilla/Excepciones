package Entidades;

import Enum.Estado;
import Execpciones.DamageDeviceException;
import Execpciones.DestroyedDeviceException;
import Execpciones.EnergiaInsuficienteException;
import Interfaz.Arreglar;
import Interfaz.Reparar;
import Interfaz.Usar;

import java.util.Objects;
import java.util.Random;

public class Radar implements Usar, Reparar, Arreglar {
    
    private Estado estado;
    private int consumoE;
    private ObjetoVolador[] objetosVoladores = new ObjetoVolador[10];

    Random random = new Random();


    public Radar() {
    }

    public Radar(Estado estado, int consumoE, ObjetoVolador[] objetosVoladores) {
        this.estado = estado;
        this.consumoE = consumoE;
        this.objetosVoladores = objetosVoladores;
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

    public ObjetoVolador[] getObjetosVoladores() {
        return this.objetosVoladores;
    }

    public void setObjetosVoladores(ObjetoVolador[] objetosVoladores) {
        this.objetosVoladores = objetosVoladores;
    }

    public Radar estado(Estado estado) {
        setEstado(estado);
        return this;
    }

    public Radar consumoE(int consumoE) {
        setConsumoE(consumoE);
        return this;
    }

    public Radar objetosVoladores(ObjetoVolador[] objetosVoladores) {
        setObjetosVoladores(objetosVoladores);
        return this;
    }

    public int usarRadar(Armadura arm, int tiempo) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        if (estado.equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();    
        }
        if (estado.equals(Estado.DANIADO)) {
            throw new DamageDeviceException();
        }
        int eConsumida = usar(1, tiempo);
        if (eConsumida > arm.getReactor()) {
            throw new EnergiaInsuficienteException();
        } else {
            System.out.println("Objetos Voladores encontrados");
            for (ObjetoVolador objetoVolador : objetosVoladores) {
                System.out.println(objetoVolador);
            }
            System.out.println("");
            System.out.println("Energía consumimda al usar el Radar = " + eConsumida);
            arm.setReactor(arm.getReactor() - eConsumida);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                setEstado(Estado.DANIADO);
                System.out.println(" + Alerta!");
                System.out.println("  - Dispositivo Radar dañado");
            }
            return eConsumida;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Radar)) {
            return false;
        }
        Radar radar = (Radar) o;
        return Objects.equals(estado, radar.estado) && consumoE == radar.consumoE && Objects.equals(objetosVoladores, radar.objetosVoladores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado, consumoE, objetosVoladores);
    }

    @Override
    public String toString() {
        return "{" +
            " Estado = " + getEstado() +
            " ConsumoE = " + getConsumoE();
    }

    @Override
    public boolean arreglarDispositivo(int prob) throws DestroyedDeviceException {
        
        if (getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        }
        int probDestruido = random.nextInt(10) + 1;
        if (probDestruido <= prob) {
            setEstado(Estado.DESTRUIDO);
            System.out.println("El Dispositivo Radar no se pudo reparar y quedó destruido");
            return false;
        } else {
            boolean reparado = repararDispositivo(4);
            if (!reparado) {
                arreglarDispositivo(3);
            } else {
                setEstado(Estado.OPTIMO);
                return true;
            }
        }
        System.out.println("Arreglar la recursión de este método");
        return false;
    }

    @Override
    public boolean repararDispositivo(int prob) {
        
        int probDamage = random.nextInt(10) + 1;
        if (probDamage <= prob) {
            System.out.println("Dispositivo Radar reparado");
            return true;
        } else {
            System.out.println("El Dispositivo Radar no se pudo reparar");
            return false;
        }
    }

    @Override
    public int usar(int intensidad, int tiempo) {
        
        return consumoE * intensidad * tiempo;
    }
    
}

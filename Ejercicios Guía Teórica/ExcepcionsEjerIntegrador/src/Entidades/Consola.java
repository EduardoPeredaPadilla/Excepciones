package Entidades;

import java.util.Random;

import Enum.Estado;
import Execpciones.DamageDeviceException;
import Execpciones.DestroyedDeviceException;
import Execpciones.EnergiaInsuficienteException;
import Interfaz.Arreglar;
import Interfaz.Reparar;
import Interfaz.Usar;


public class Consola implements Usar, Reparar, Arreglar {
    
    private Estado estado;
    private int consumoE;

    Random random = new Random();

    public Consola() {
    }

    public Consola(Estado estado, int consumoE) {
        this.estado = estado;
        this.consumoE = consumoE;
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

    public int escribirJARVIS(Armadura arm, int tiempo) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

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
            System.out.println("Energía consumida al recibir mensajes escritos por consola = " + eConsumida);
            arm.setReactor(arm.getReactor() - eConsumida);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                setEstado(Estado.DANIADO);
                System.out.println(" + Alerta!");
                System.out.println("  - Dispositivo Consola dañado");
            }
            return eConsumida;
        }
    }



    @Override
    public String toString() {
        return "{" +
            " Estado = " + getEstado() +
            " ConsumoE = " + getConsumoE() + "}";
    }

    @Override
    public int usar(int intensidad, int tiempo) {
        
        return consumoE * intensidad * tiempo;
    }

    @Override
    public boolean repararDispositivo(int prob) {
        
        int probDamage = random.nextInt(10) + 1;
        if (probDamage <= prob) {
            System.out.println("Dispositivo Consola reparado");
            return true;
        } else {
            System.out.println("El Dispositivo Consola no se pudo reparar");
            return false;
        }
    }

    @Override
    public boolean arreglarDispositivo(int prob) throws DestroyedDeviceException {
        
        if (getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        }
        int probDestruido = random.nextInt(10) + 1;
        if (probDestruido <= prob) {
            setEstado(Estado.DESTRUIDO);
            System.out.println("El Dispositivo Consola no se pudo reparar y quedó destruido");
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

}

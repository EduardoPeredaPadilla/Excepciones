package Entidades;

import java.util.Random;

import Enum.Estado;
import Execpciones.DamageDeviceException;
import Execpciones.DestroyedDeviceException;
import Execpciones.EnergiaInsuficienteException;
import Interfaz.Arreglar;
import Interfaz.Reparar;
import Interfaz.Usar;



public class Bota implements Usar, Reparar, Arreglar {
    
    private String lado;
    private Estado estado;
    private int consumoE;

    Random random = new Random();


    public Bota() {
    }

    public Bota(String lado, Estado estado, int consumoE) {
        this.lado = lado;
        this.estado = estado;
        this.consumoE = consumoE;
    }

    public String getLado() {
        return this.lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
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

    public int caminar(Armadura arm, int tiempo) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {


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
            System.out.println("Energía consumida bota " + lado + " = " + eConsumida);
            arm.setReactor(arm.getReactor() - eConsumida);
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                setEstado(Estado.DANIADO);
                System.out.println(" + Alerta!");
                System.out.println("  - Dispositivo bota " + lado + " dañado");
            }
            return eConsumida;
        }
          
    }
    
    public int correr(Armadura arm, int tiempo) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        if (estado.equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();    
        }
        if (estado.equals(Estado.DANIADO)) {
            throw new DamageDeviceException();
        }
        consumoE = consumoE * 2;
        int eConsumida = usar(1, tiempo);
        if (eConsumida > arm.getReactor()) {
            consumoE = consumoE / 2;
            throw new EnergiaInsuficienteException();
        } else {
            System.out.println("Energía consumida bota " + lado + " = " + eConsumida);
            arm.setReactor(arm.getReactor() - eConsumida);
            consumoE = consumoE / 2;
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                setEstado(Estado.DANIADO);
                System.out.println(" + Alerta!");
                System.out.println("  - Dispositivo bota " + lado + " dañado");
            }
            return eConsumida;
        }
    }

    public int propulsar(Armadura arm, int tiempo) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        if (estado.equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();    
        }
        if (estado.equals(Estado.DANIADO)) {
            throw new DamageDeviceException();
        }
        consumoE = consumoE * 3;
        int eConsumida = usar(1, tiempo);
        if (eConsumida > arm.getReactor()) {
            consumoE = consumoE / 3;
            throw new EnergiaInsuficienteException();
        } else {
            System.out.println("Energía consumida bota " + lado + " = " + eConsumida);
            arm.setReactor(arm.getReactor() - eConsumida);
            consumoE = consumoE / 3;
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                setEstado(Estado.DANIADO);
                System.out.println(" + Alerta!");
                System.out.println("  - Dispositivo bota " + lado + " dañado");
            }
            return eConsumida;
        }
    }

    public int volar(Armadura arm, int tiempo) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        if (estado.equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();    
        }
        if (estado.equals(Estado.DANIADO)) {
            throw new DamageDeviceException();
        }
        consumoE = consumoE * 3;
        int eConsumida = usar(1, tiempo);
        if (eConsumida > arm.getReactor()) {
            consumoE = consumoE / 3;
            throw new EnergiaInsuficienteException();
        } else {
            System.out.println("Energía consumida bota " + lado + " = " + eConsumida);
            arm.setReactor(arm.getReactor() - eConsumida);
            consumoE = consumoE / 3;
            int probDamage = random.nextInt(10) + 1;
            if (probDamage <= 3) {
                setEstado(Estado.DANIADO);
                System.out.println(" + Alerta!");
                System.out.println("  - Dispositivo bota " + lado + " dañado");
            }
            return eConsumida;
        }
    }

    @Override
    public String toString() {
        return "{" +
            " Estado = " + getEstado() +
            ", ConsumoE = " + getConsumoE() + " }";
    }

    @Override
    public int usar(int intensidad, int tiempo) {
        
        return consumoE * intensidad * tiempo;
    }

    @Override
    public boolean repararDispositivo(int prob) {

        int probDamage = random.nextInt(10) + 1;
        if (probDamage <= prob) {
            System.out.println("Dispositivo bota " + lado + " reparado");
            return true;
        } else {
            System.out.println("El Dispositivo bota " + lado + " no se pudo reparar");
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
            System.out.println("El Dispositivo bota " + lado + " no se pudo reparar y quedó destruido");
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

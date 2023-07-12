package Services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entidades.Armadura;
import Entidades.Bota;
import Entidades.Casco;
import Entidades.Consola;
import Entidades.Guante;
import Entidades.ObjetoVolador;
import Entidades.Radar;
import Entidades.Sintetizador;
import Enum.Estado;
import Execpciones.DamageDeviceException;
import Execpciones.DestroyedDeviceException;
import Execpciones.EnergiaInsuficienteException;

public class ArmService {

    Scanner scan = new Scanner(System.in);
    
    public Armadura crearArmadura() {

        Armadura arm = new Armadura();
        arm.setColorPrimario("Rojo");
        arm.setColorSecundario("Dorado");
        arm.setResistencia(100);
        arm.setEnergia(100000);
        arm.setReactor(arm.getEnergia());
        
        Bota botaIzq = new Bota();
        botaIzq.setLado("Izq");
        botaIzq.setEstado(Estado.OPTIMO);
        botaIzq.setConsumoE(100);
        arm.setBotaIzq(botaIzq);

        Bota botaDer = new Bota("Der", Estado.OPTIMO, 100);
        arm.setBotaDer(botaDer);

        Guante guanteIzq = new Guante("Izq", Estado.OPTIMO, 100);
        arm.setGuanteIzq(guanteIzq);

        Guante guanteDer = new Guante("Der", Estado.OPTIMO, 100);
        arm.setGuanteDer(guanteDer);

        Consola consola = new Consola(Estado.OPTIMO, 50);
        Sintetizador sint = new Sintetizador(Estado.OPTIMO, 50);

        Casco casco = new Casco(Estado.OPTIMO, consola.getConsumoE() + sint.getConsumoE(), consola, sint);
        arm.setCasco(casco);
        arm.setEnergiaMaxima(arm.getEnergia());
        arm.setBateria((arm.getReactor() / arm.getEnergiaMaxima()) * 100);

        ObjVolService objVolServ = new ObjVolService();
        ObjetoVolador[] objetosVoladores = new ObjetoVolador[10];
        for (int i = 0; i < objetosVoladores.length; i++) {
            ObjetoVolador objVol = objVolServ.agregarObjetoVolador();
            objetosVoladores[i] = objVol;
        }
        
        Radar radar = new Radar(Estado.OPTIMO, 20, objetosVoladores);
        arm.setRadar(radar);

        return arm;
    }

    public void caminar(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Caminar");
        int consumoE = arm.getBotaIzq().caminar(arm, 10) + arm.getBotaDer().caminar(arm, 10);
        //int consumoE = arm.getBotaIzq().usar(1, 10) + arm.getBotaDer().usar(1, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int)arm.getReactor());
        arm.setBateria((arm.getReactor() / arm.getEnergiaMaxima()) * 100);
        System.out.println("Energia Consumida al Caminar = " + consumoE);
        //arm.setReactor(arm.getReactor() - consumoE);
    }

    public void correr(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Correr");
        int consumoE = arm.getBotaIzq().correr(arm, 10) + arm.getBotaDer().correr(arm, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int)arm.getReactor());
        arm.setBateria((arm.getReactor() / arm.getEnergiaMaxima()) * 100);
        System.out.println("Energía Consumida al Correr = " + consumoE);

    }

    public void propulsar(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Propulsar");
        int consumoE = arm.getBotaIzq().propulsar(arm, 10) + arm.getBotaDer().propulsar(arm, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int)arm.getReactor());
        arm.setBateria((arm.getReactor() / arm.getEnergiaMaxima()) * 100);
        System.out.println("Energía Consumida al Propulsarse = " + consumoE);

    }

    public void volar(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Volar");
        int consumoE = arm.getBotaIzq().volar(arm, 10) + arm.getBotaDer().volar(arm, 10) + arm.getGuanteIzq().volar(arm, 10) + arm.getGuanteDer().volar(arm, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int) arm.getReactor());
        arm.setBateria((arm.getReactor() / arm.getEnergiaMaxima()) * 100);
        System.out.println("Energía Consumida al Volar = " + consumoE);
    }

    public void disparar(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Disparar");
        int consumoE = arm.getGuanteIzq().disparar(arm, 10) + arm.getGuanteDer().disparar(arm, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int) arm.getReactor());
        arm.setBateria((arm.getReactor() / arm.getEnergiaMaxima()) * 100);
        System.out.println("Energía Consumida al Disparar = " + consumoE);
    }

    public void escribirJARVIS(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Mensaje de JARVIS recibido por Consola");
        int consumoE = arm.getCasco().getConsola().escribirJARVIS(arm, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int) arm.getReactor());
        arm.setBateria((arm.getReactor() / arm.getEnergiaMaxima()) * 100);
        System.out.println("Energía Consumida al usar la Consola = " + consumoE);
    }

    public void hablarJARVIS(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Mensaje de JARVIS recibido por Sintetizador");
        int consumoE = arm.getCasco().getSint().hablarJARVIS(arm, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int) arm.getReactor());
        
        System.out.println("Energía Consumida al usar el Sintetizador = " + consumoE);
    }

    public void revisarEstadoArmadura(Armadura arm) throws InputMismatchException, DestroyedDeviceException {

        ArrayList<Object> dispositivosDaniados = new ArrayList<>();

        if (arm.getBotaIzq().getEstado().equals(Estado.DANIADO)) {
            dispositivosDaniados.add(arm.getBotaIzq());
        } else if (arm.getBotaIzq().getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        }
        if (arm.getBotaDer().getEstado().equals(Estado.DANIADO)) {
            dispositivosDaniados.add(arm.getBotaDer());
        } else if (arm.getBotaDer().getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        }
        if (arm.getGuanteIzq().getEstado().equals(Estado.DANIADO)) {
            dispositivosDaniados.add(arm.getGuanteIzq());
        } else if (arm.getGuanteIzq().getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        } 
        if (arm.getGuanteDer().getEstado().equals(Estado.DANIADO)) {
            dispositivosDaniados.add(arm.getGuanteDer());
        } else if (arm.getGuanteDer().getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        }
        if (arm.getCasco().getConsola().getEstado().equals(Estado.DANIADO)) {
            dispositivosDaniados.add(arm.getCasco().getConsola());
        } else if (arm.getCasco().getConsola().getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        }
        if (arm.getCasco().getSint().getEstado().equals(Estado.DANIADO)) {
            dispositivosDaniados.add(arm.getCasco().getSint());
        } else if (arm.getCasco().getSint().getEstado().equals(Estado.DESTRUIDO)) {
            throw new DestroyedDeviceException();
        }

        if (!dispositivosDaniados.isEmpty()) {
            System.out.println("Se encontraron los siguientes Dispositivos dañados");
            for (Object object : dispositivosDaniados) {
                if (object instanceof Bota) {
                    Bota bota = (Bota) object;
                    System.out.println(" Bota "+ bota.getLado() + bota.toString());
                } else if (object instanceof Guante) {
                    Guante guante = (Guante) object;
                    System.out.println(" Guante "+ guante.getLado() + guante.toString());
                } else if (object instanceof Consola) {
                    Consola consola = (Consola) object;
                    System.out.println("Consola " + consola.toString());
                } else if (object instanceof Sintetizador) {
                    Sintetizador sint = (Sintetizador) object;
                    System.out.println("Sintetizador " + sint.toString());
                } else if (object instanceof Radar) {
                    Radar radar = (Radar) object;
                    System.out.println("Radar " + radar.toString());
                }
            }
            System.out.println("");
            int resp = 0;
            do {
                System.out.println("Deseas intentar reparar los dispositivos dañados?");
                System.out.println("(1) Si");
                System.out.println("(2). No");
                resp = scan.nextInt();
                /*try {
                    resp = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Dato de respuesta inválido desde Service");
                    revisarEstadoArmadura(arm);
                    scan.close();
                    return;
                }
                /*if (resp != 1 && resp != 2 ) {
                    System.out.println("Opción inválida");
                } else */ 
                if (resp == 1) {
                    arreglarDispositivos(arm, dispositivosDaniados);
                } else if (resp == 2) {
                    System.out.println("No se intento repara los Dispositivos");
                }
            } while (resp != 1 && resp != 2);
            
        } else {
            System.out.println(" No se encontraron Dispositivos Dañados");
        }

        
    }

    public void arreglarDispositivos(Armadura arm, ArrayList<Object> dispositivosDaniados) throws DestroyedDeviceException {

        if (!dispositivosDaniados.isEmpty()) {
            for (Object object : dispositivosDaniados) {
                if (object instanceof Bota) {
                    Bota botaRep = (Bota) object;
                    /*if (botaRep.getEstado().equals(Estado.DESTRUIDO)) {
                        throw new DestroyedDeviceException();
                    }*/
                    if (botaRep.arreglarDispositivo(3)) {
                        if (botaRep.getLado().equalsIgnoreCase("Izq")) {
                            arm.setBotaIzq(botaRep);
                        } else {
                            arm.setBotaDer(botaRep);
                        }
                    }
                } else if(object instanceof Guante) {
                    Guante guanteRep = (Guante) object;
                    if (guanteRep.arreglarDispositivo(3)) {
                        guanteRep.setEstado(Estado.OPTIMO);
                        if (guanteRep.getLado().equalsIgnoreCase("Izq")) {
                            arm.setGuanteIzq(guanteRep);
                        } else {
                            arm.setGuanteDer(guanteRep);
                        }
                    }
                } else if (object instanceof Consola) {
                    Consola consolaRep = (Consola) object;
                    if (consolaRep.arreglarDispositivo(3)) {
                        consolaRep.setEstado(Estado.OPTIMO);
                        arm.getCasco().setConsola(consolaRep);
                    }
                } else if (object instanceof Sintetizador) {
                    Sintetizador sintRep = (Sintetizador) object;
                    if (sintRep.arreglarDispositivo(3)) {
                        sintRep.setEstado(Estado.OPTIMO);
                        arm.getCasco().setSint(sintRep);
                    }
                } else if (object instanceof Radar) {
                    Radar radar = (Radar) object;
                    if (radar.arreglarDispositivo(3)) {
                        radar.setEstado(Estado.OPTIMO);
                        arm.setRadar(radar);
                    }
                }
            }
        }
    }

    public void usarRadar(Armadura arm) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("Buscando Objetos Voladores con el Radar");
        int consumoE = arm.getRadar().usarRadar(arm, 10);
        if (consumoE > arm.getEnergia()) {
            throw new EnergiaInsuficienteException();
        }
        arm.setEnergia((int) arm.getReactor());

        System.out.println("Energía consumida al usar el Radar = " + consumoE);
    }

    public void mostrarObjVolHostiles(Armadura arm) throws InputMismatchException, EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        Scanner scan = new Scanner(System.in);
        int i = 1;  
        int resp;
        System.out.println("* Objetos Voladores Hostiles");
        ObjetoVolador[] objetosVoladores = arm.getRadar().getObjetosVoladores();
        for (ObjetoVolador objetoVolador : objetosVoladores) {
            if (objetoVolador.isHostil() && !objetoVolador.getEstado().equals(Estado.DESTRUIDO)) {
                System.out.println(i + ". " + objetoVolador);
                i++;
                System.out.println("");
                do {
                    System.out.println("Deseas atacar este Objeto Volador");
                    System.out.println("(1) Si");
                    System.out.println("(2) No");
                    resp = scan.nextInt();
                    /*try {
                        resp = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Respuesta incorrecta");
                    }*/
                    if (resp == 1) {
                        atacar(arm, objetoVolador);
                    } else if (resp == 2) {
                        System.out.println("No se ataco al Objeto Volador");
                        System.out.println("");
                    } 
                } while (resp != 1 && resp != 2 );
                
            }
        }
        



    }

    public void atacar(Armadura arm, ObjetoVolador objVol) throws EnergiaInsuficienteException, DamageDeviceException, DestroyedDeviceException {

        System.out.println("* Atacar");
        int distancia;
        int[] coordenadas = objVol.getCoordenadas();
        distancia = ((int)Math.sqrt(Math.pow((coordenadas[0]-0), 2) + Math.pow((coordenadas[1]-0), 2) + Math.pow((coordenadas[2]-0), 2)));
        System.out.println("El Objeto Volador se encuentra a una distancia de " + distancia);

        do {
            disparar(arm);
            int resistObj = objVol.getResistencia();
            objVol.setResistencia(objVol.getResistencia() - distancia);
            if (objVol.getResistencia() <= 0) {
                objVol.setEstado(Estado.DESTRUIDO);
            } else if (objVol.getResistencia() < resistObj) {
                objVol.setEstado(Estado.DANIADO);
            }
        } while (arm.getEnergia() > 0 || objVol.getResistencia() > 0);

        if (objVol.getResistencia() <= 0) {
            System.out.println("El ObjVol " + objVol + " ha sido destruido");
            System.out.println("");
        } else if(arm.getEnergia() <= 0) {
            System.out.println("Se ha agotado la energía de la armadura");
            System.out.println("");
        }
        System.out.println("");
    }    

}

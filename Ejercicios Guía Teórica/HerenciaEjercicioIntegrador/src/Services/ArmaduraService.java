package Services;

import java.util.Random;
import Entidades.Armadura;
import Entidades.Consola;
import Entidades.Sintetizador;

public class ArmaduraService {
    
    Random random = new Random();
    

    public Armadura nuevaArmadura() {

        Armadura armadura = new Armadura();
        armadura.setColorPrimario("Rojo");
        armadura.setColorSecundario("Dorado");
        
        
        BotaService botServ = new BotaService();
        armadura.setBotas(botServ.addBotas(armadura.getBotas()));
        

        GuanteService guantServ = new GuanteService();
        armadura.setGuantes(guantServ.addGuantes(armadura.getGuantes()));
        

        armadura.setMaterial("Aleación Acero y Metal desconocido");
        armadura.setResistencia(1000);

        armadura.setSalud(100);
        armadura.setEnergia(2000);

        armadura.setEnergiaMax(armadura.getEnergia());

        armadura.setBateria(100);
        armadura.setReactor(random.nextFloat(Float.MAX_VALUE));

        ConsolaService consServ = new ConsolaService();
        Consola consola = consServ.addConsola();
        armadura.setConsola(consola);

        SintService sintServ = new SintService();
        Sintetizador sint = sintServ.addSintetizador();
        armadura.setSint(sint);

        return armadura;
    }

    public void caminarArm(Armadura armadura, int tiempo) {
        
        BotaService botServ = new BotaService();
        Integer consumoEnergia = botServ.caminarBotas(armadura.getBotas(), tiempo);
        if (consumoEnergia == 0) {
            System.out.println("Reparando daños ...");
            botServ.repararBotas(armadura.getBotas());
        }
        System.out.println("Energía Consumida Caminando = " + consumoEnergia);
        armadura.setEnergia(armadura.getEnergia() - consumoEnergia);

        armadura.setBateria(((float) armadura.getEnergia()/armadura.getEnergiaMax()) * 100);
    }

    public void correrArm(Armadura armadura, int tiempo) {

        BotaService botServ = new BotaService();
        Integer consumoEnergia = botServ.correrBotas(armadura.getBotas(), tiempo);
        if (consumoEnergia == 0) {
            System.out.println("Reparando daños ...");
            botServ.repararBotas(armadura.getBotas());
        }
        System.out.println("Energía Consumida Corriendo = " + consumoEnergia);
        armadura.setEnergia(armadura.getEnergia() - consumoEnergia);

        armadura.setBateria(((float) armadura.getEnergia()/armadura.getEnergiaMax()) * 100);
    }

    public void propulsarArm(Armadura armadura, int tiempo) {

        BotaService botServ = new BotaService();
        Integer consumoEnergia = botServ.propulsarBotas(armadura.getBotas(), tiempo);
        if (consumoEnergia == 0) {
            System.out.println("Reparando daños ...");
            botServ.repararBotas(armadura.getBotas());
        }
        System.out.println("Energía Consumida Propulsandose = " + consumoEnergia);
        armadura.setEnergia(armadura.getEnergia() - consumoEnergia);

        armadura.setBateria(((float) armadura.getEnergia()/armadura.getEnergiaMax()) * 100);
    }


    public void volarArm(Armadura armadura, int tiempo) {

        BotaService botServ = new BotaService();
        Integer consumoEnergia = botServ.volarBotas(armadura.getBotas(), tiempo);
        if (consumoEnergia == 0) {
            System.out.println("Reparando daños ...");
            botServ.repararBotas(armadura.getBotas());
        }
        GuanteService guantServ = new GuanteService();
        consumoEnergia = consumoEnergia + guantServ.volarGuantes(armadura.getGuantes(), tiempo);
        System.out.println("Energía Consumida Volando = " + consumoEnergia);
        armadura.setEnergia(armadura.getEnergia() - consumoEnergia);

        armadura.setBateria(((float) armadura.getEnergia()/armadura.getEnergiaMax()) * 100);
    }

    public void dispararArm(Armadura armadura, int tiempo) {

        GuanteService guantServ = new GuanteService();
        Integer consumoEnergia = guantServ.dispararGuantes(armadura.getGuantes(), tiempo);
        System.out.println("Energía Consumida Disparando = " + consumoEnergia);
        armadura.setEnergia(armadura.getEnergia() - consumoEnergia);

        armadura.setBateria(((float) armadura.getEnergia()/armadura.getEnergiaMax()) * 100);
    }

    public void escribirConsola(Armadura armadura, int tiempo) {

        

        Consola consola = new Consola();
        Integer consumoEnergia = consola.escribir(armadura.getConsola(), tiempo);
        System.out.println("Energía Consumida Escribiendo = " + consumoEnergia);
        armadura.setEnergia(armadura.getEnergia() - consumoEnergia);

        armadura.setBateria(((float) armadura.getEnergia()/armadura.getEnergiaMax()) * 100);

        
        
    }

    public void hablarSint(Armadura armadura, int tiempo) {

        
        Sintetizador sint = new Sintetizador();
        Integer consumoEnergia = sint.hablar(armadura.getSint(), tiempo);
        System.out.println("Energía Consumida Hablando = " + consumoEnergia);
        armadura.setEnergia(armadura.getEnergia() - consumoEnergia);

        armadura.setBateria(((float) armadura.getEnergia()/armadura.getEnergiaMax()) * 100);

        
        
    }

    public void mostrarArmadura(Armadura armadura) {

        System.out.println(armadura.toString());
    }


    
}

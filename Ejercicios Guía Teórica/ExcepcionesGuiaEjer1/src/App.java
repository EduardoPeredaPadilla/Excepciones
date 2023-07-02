import Entidades.Persona;
import Services.PersonaService;

public class App {
    public static void main(String[] args)  {
        
        PersonaService perServ = new PersonaService();
        

        try {
            //Persona per = new Persona();
            boolean esMayor = perServ.esMayorDeEdad(null);
        } catch (Exception e) {
            System.out.println("Dentro del Catch");
            System.out.println(e.getMessage());
        }


    }


    
}

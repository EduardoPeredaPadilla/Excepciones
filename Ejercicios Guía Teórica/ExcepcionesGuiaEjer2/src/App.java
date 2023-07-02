import Entidades.Arreglo;

public class App {
    public static void main(String[] args) throws Exception {
        

        String[] letras = new String[3];
        letras[0] = "Palabra1";
        letras[1] = "Palabra2";
        letras[2] = "Palabra3";
        
        Arreglo arreglo = new Arreglo(letras);

        try {
            for (int index = 0; index < 5; index++) {
            System.out.println(arreglo.getLetras(index));
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera del rango");
            System.out.println(e.getMessage());
        }

        
        
        

    }
}

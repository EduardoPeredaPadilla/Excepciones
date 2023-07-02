package Entidades;
import java.util.Objects;

public class Arreglo {
    
    String[] letras = new String[3];


    public Arreglo() {
    }

    public Arreglo(String[] letras) {
        this.letras = letras;
    }

    public String[] getLetras() {
        return this.letras;
    }

    public String getLetras(int i) {
        return this.letras[i];
    }

    public void setLetras(String[] letras) {
        this.letras = letras;
    }

    public Arreglo letras(String[] letras) {
        setLetras(letras);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " letras='" + getLetras() + "'" +
            "}";
    }
    

}

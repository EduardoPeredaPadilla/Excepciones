package Entidades;

public class Persona {
    
    private String nombre;
    private int edad;
    private String sexo;
    private float peso;
    private float altura;


    public Persona() {
    }

    public Persona(String nombre, int edad, String sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Persona nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Persona edad(int edad) {
        setEdad(edad);
        return this;
    }

    public Persona sexo(String sexo) {
        setSexo(sexo);
        return this;
    }

    public Persona peso(float peso) {
        setPeso(peso);
        return this;
    }

    public Persona altura(float altura) {
        setAltura(altura);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", peso='" + getPeso() + "'" +
            ", altura='" + getAltura() + "'" +
            "}";
    }
    

}

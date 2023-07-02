package Entidades;
import java.util.Objects;

public class DivisionNumero {
    
    private int num1;
    private int num2;


    public DivisionNumero() {
    }

    public DivisionNumero(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return this.num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return this.num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public DivisionNumero num1(int num1) {
        setNum1(num1);
        return this;
    }

    public DivisionNumero num2(int num2) {
        setNum2(num2);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " num1='" + getNum1() + "'" +
            ", num2='" + getNum2() + "'" +
            "}";
    }
    

}

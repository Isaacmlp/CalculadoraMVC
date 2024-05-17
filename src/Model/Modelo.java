package Model;

public class Modelo {

    public double Operaciones (double num1) {
        return Math.sqrt(num1);
    }

    public double Operaciones (double num1, double num2,String Simbolo) {
        switch (Simbolo) {
            case "+" -> {
                return (num1 + num2);
            }
            case "-" -> {
                return (num1 - num2);
            }
            case "*" -> {
                return (num1 * num2);
            }
            case "/" -> {
                return (num1 / num2);
            }
            case null, default -> {
                return 0;
            }
        }
    }

    public boolean VerificarDobule (String Texto) {

        char[] cadena = Texto.toCharArray();

        for (int i = 0; i < Texto.length(); i++ ) {
            if (cadena[i] == '.') {
                return true;
            }
        }
        return false;
    }

    public String EliminarCaracter (String Texto) {
        char[] caracteres = Texto.toCharArray();
        Texto = "";

        for (int i = 0; i < caracteres.length - 1; i++) {
            Texto += caracteres[i];
        }
        return Texto;
    }



}
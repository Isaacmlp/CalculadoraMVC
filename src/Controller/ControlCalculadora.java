package Controller;

/* Importando Modelo y Vista */

import Model.Modelo;
import View.Calculadora;

/* Importando Librerias*/

import javax.swing.*;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class ControlCalculadora implements ActionListener, KeyListener, MouseListener {
    Calculadora c;
    Modelo modelo;

    public ControlCalculadora(Calculadora c, Modelo modelo) {
        this.c = c;
        this.modelo = modelo;
        c.addKeyListener(this);
        c.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String text = source.getText();
        String soporte;
        switch (text) {
            case "+":
                c.modificarLabel("+");
                break;
            case "*":
                c.modificarLabel("*");
                break;
            case "/":
                c.modificarLabel("/");
                break;
            case "-":
                c.modificarLabel("-");
                break;
            case ".":
                c.modificarLabel(".");
                break;
            case "=":
                soporte = c.getlbl().getText();
                StringBuilder operando1 = new StringBuilder();
                StringBuilder operando2 = new StringBuilder();
                String simbolo = "";
                String result ;
                char[] textolabel;
                textolabel = soporte.toCharArray();
                double[] operandos = new double[2];
                double resultado;
                int resultadoInt;
                boolean status = false;
                boolean raiz = false;


                for (int i = 0 ; i < textolabel.length ; i++) {
                    if (textolabel[i] == '√' ) {
                        raiz = true;
                        continue;
                    }

                    if (((textolabel[i] == '+') || (textolabel[i] == '-') || (textolabel[i] == '*') || (textolabel[i] == '/'))) {
                        status = true;
                        continue;
                    }

                    if (raiz) {
                        operando1.append(textolabel[i]);

                    }

                    if (status) {
                        operando2.append(textolabel[i]);
                    } else {
                        operando1.append(textolabel[i]);
                    }
                }

                if (!raiz) {
                    operandos[0] = Double.parseDouble(operando1.toString());
                    operandos[1] = Double.parseDouble(operando2.toString());
                } else {
                    operandos[0] = Double.parseDouble(operando1.toString());

                }
                for (int i = 0 ; i < soporte.length() -1; i++) {
                    if (textolabel[i] == '+') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "+");
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");

                        if(!modelo.VerificarDobule(soporte)) {
                            resultadoInt = (int) Math.round(resultado);
                            result = String.valueOf(resultadoInt);
                            c.Resultado(result);
                        } else {
                            c.Resultado(result);
                        }

                        break;
                    } else if (textolabel[i] == '-') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "-");
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");

                        if(!modelo.VerificarDobule(soporte)) {
                            resultadoInt = (int) Math.round(resultado);
                            result = String.valueOf(resultadoInt);
                            c.Resultado(result);
                        } else {
                            c.Resultado(result);
                        }
                        break;
                    } else if(textolabel[i] == '*') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "*");
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");

                        if(!modelo.VerificarDobule(soporte)) {
                            resultadoInt = (int) Math.round(resultado);
                            result = String.valueOf(resultadoInt);
                            c.Resultado(result);
                        } else {
                            c.Resultado(result);
                        }

                        break;
                    } else if(textolabel[i] == '/') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "/");
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");

                        if(!modelo.VerificarDobule(soporte)) {
                            resultadoInt = (int) Math.round(resultado);
                            result = String.valueOf(resultadoInt);
                            c.Resultado(result);
                        } else {
                            c.Resultado(result);
                        }

                        break;
                    } else if(textolabel[i] == '√') {
                        double resultad;
                        resultad = modelo.Operaciones(operandos[0]);
                        result = String.valueOf(resultad);
                        c.getlbl().setText("");
                        c.Resultado(result);
                        break;
                    }  else {
                        c.getlbl().setText("Error de Sintaxis");
                    }
                }
                break;
            case "1":
                c.modificarLabel("1");
                break;
            case "2":
                c.modificarLabel("2");
                break;
            case "3":
                c.modificarLabel("3");
                break;
            case "4":
                c.modificarLabel("4");
                break;
            case "5":
                c.modificarLabel("5");
                break;
            case "6":

                c.modificarLabel("6");
                break;
            case "7":
                c.modificarLabel("7");
                break;
            case "8":
                c.modificarLabel("8");
                break;
            case "9":
                c.modificarLabel("9");
                break;
            case "0":
                c.modificarLabel("0");
                break;
            case "%":
                c.LimpiarDisplay();
                break;
            case "√":
                c.modificarLabel("√");
                break;
            case "x2":
                c.LimpiarDisplay();
                break;
            case "1/x":
                c.LimpiarDisplay();
                break;
            case "CE":
                c.LimpiarDisplay();
                break;
            case "C":
                c.LimpiarDisplay();
                break;
            case "Delete":
                 soporte = c.getlbl().getText();
                 c.Resultado(modelo.EliminarCaracter(soporte));
                break;
            default:
                c.LimpiarDisplay();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE && e.isShiftDown()) {
            c.dispose();
        }
        String soporte;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ADD:
                c.modificarLabel("+");
                break;
            case KeyEvent.VK_MULTIPLY:
                c.modificarLabel("*");
                break;
            case KeyEvent.VK_DIVIDE:
                c.modificarLabel("/");
                break;
            case KeyEvent.VK_SUBTRACT:
                c.modificarLabel("-");
                break;
            case KeyEvent.VK_COMMA:
                c.modificarLabel(".");
                break;
            case KeyEvent.VK_ENTER:
                soporte = c.getlbl().getText();
                StringBuilder operando1 = new StringBuilder();
                StringBuilder operando2 = new StringBuilder();
                String[] simbolo;
                String result;
                char[] textolabel;
                textolabel = soporte.toCharArray();
                double[] operandos = new double[2];
                double resultado;
                int resultadoInt;
                boolean status = false;
                boolean raiz = false;

                for (int i = 0 ; i < textolabel.length ; i++) {
                    if (textolabel[i] == '√' ) {
                        raiz = true;
                        continue;
                    }

                    if (((textolabel[i] == '+') || (textolabel[i] == '-') || (textolabel[i] == '*') || (textolabel[i] == '/'))) {
                        status = true;
                        continue;
                    }

                    if (raiz) {
                        operando1.append(textolabel[i]);
                        break;
                    }

                    if (status) {
                        operando2.append(textolabel[i]);
                    } else {
                        operando1.append(textolabel[i]);
                    }
                }

                operandos[0] = Double.parseDouble(operando1.toString());
                operandos[1] = Double.parseDouble(operando2.toString());

                for (int i = 0 ; i < soporte.length() -1; i++) {
                    if (textolabel[i] == '+') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "+");
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");

                        if(!modelo.VerificarDobule(soporte)) {
                            resultadoInt = (int) Math.round(resultado);
                            result = String.valueOf(resultadoInt);
                            c.Resultado(result);
                        } else {
                            c.Resultado(result);
                        }

                        break;
                    } else if (textolabel[i] == '-') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "-");
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");

                        if(!modelo.VerificarDobule(soporte)) {
                            resultadoInt = (int) Math.round(resultado);
                            result = String.valueOf(resultadoInt);
                            c.Resultado(result);
                        } else {
                            c.Resultado(result);
                        }
                        break;
                    } else if(textolabel[i] == '*') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "*");
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");

                        if(!modelo.VerificarDobule(soporte)) {
                            resultadoInt = (int) Math.round(resultado);
                            result = String.valueOf(resultadoInt);
                            c.Resultado(result);
                        } else {
                            c.Resultado(result);
                        }

                        break;
                    } else if(textolabel[i] == '/') {
                        resultado = modelo.Operaciones(operandos[0], operandos[1], "/");
                        if (operandos[0] == 0 || operandos[1] == 0) {
                            c.getlbl().setText("Error de sintaxsis");
                        } else {
                            result = String.valueOf(resultado);
                            c.getlbl().setText("");
                            c.Resultado(result);
                        }


                        break;
                    } else if(textolabel[i] == '√') {
                        double resultad;
                        resultad = modelo.Operaciones(operandos[0]);
                        result = String.valueOf(resultad);
                        c.getlbl().setText("");
                        c.Resultado(result);
                        break;
                    }  else {
                        c.getlbl().setText("Error de Sintaxis");
                    }
                }
                break;
            case KeyEvent.VK_NUMPAD1:
                c.modificarLabel("1");
                break;
            case KeyEvent.VK_NUMPAD2:
                c.modificarLabel("2");
                break;
            case KeyEvent.VK_NUMPAD3:
                c.modificarLabel("3");
                break;
            case KeyEvent.VK_NUMPAD4:
                c.modificarLabel("4");
                break;
            case KeyEvent.VK_NUMPAD5:
                c.modificarLabel("5");
                break;
            case KeyEvent.VK_NUMPAD6:
                c.modificarLabel("6");
                break;
            case KeyEvent.VK_NUMPAD7:
                c.modificarLabel("7");
                break;
            case KeyEvent.VK_NUMPAD8:
                c.modificarLabel("8");
                break;
            case KeyEvent.VK_NUMPAD9:
                c.modificarLabel("9");
                break;
            case KeyEvent.VK_NUMPAD0:
                c.modificarLabel("0");
                break;
            case KeyEvent.VK_BACK_SPACE: /* Representa la tecla de borrar */
                soporte = c.getlbl().getText();
                c.Resultado(modelo.EliminarCaracter(soporte));
                break;
            /*case "%":
                c.LimpiarDisplay();
                break;
            case "√":
                c.modificarLabel("√");
                break;
            case "x2":
                c.LimpiarDisplay();
                break;
            case "1/x":
                c.LimpiarDisplay();
                break;
            case "CE":
                c.LimpiarDisplay();
                break;
            case "C":
                c.LimpiarDisplay();
                break;

             */
            default:
                c.LimpiarDisplay();
                break;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON3) { // verifico que si el click que se realizo corresponde al click derecho que es BUTTON 3
            String soporte;
            soporte = c.getlbl().getText();
            StringBuilder operando1 = new StringBuilder();
            StringBuilder operando2 = new StringBuilder();
            String[] simbolo;
            String result;
            char[] textolabel;
            textolabel = soporte.toCharArray();
            double[] operandos = new double[2];
            double resultado;
            int resultadoInt;
            boolean status = false;
            boolean raiz = false;

            for (int i = 0 ; i < textolabel.length ; i++) {
                if (textolabel[i] == '√' ) {
                    raiz = true;
                    continue;
                }

                if (((textolabel[i] == '+') || (textolabel[i] == '-') || (textolabel[i] == '*') || (textolabel[i] == '/'))) {
                    status = true;
                    continue;
                }

                if (raiz) {
                    operando1.append(textolabel[i]);
                    break;
                }

                if (status) {
                    operando2.append(textolabel[i]);
                } else {
                    operando1.append(textolabel[i]);
                }
            }

            operandos[0] = Double.parseDouble(operando1.toString());
            operandos[1] = Double.parseDouble(operando2.toString());

            for (int i = 0 ; i < soporte.length() -1; i++) {
                if (textolabel[i] == '+') {
                    resultado = modelo.Operaciones(operandos[0], operandos[1], "+");
                    result = String.valueOf(resultado);
                    c.getlbl().setText("");

                    if(!modelo.VerificarDobule(soporte)) {
                        resultadoInt = (int) Math.round(resultado);
                        result = String.valueOf(resultadoInt);
                        c.Resultado(result);
                    } else {
                        c.Resultado(result);
                    }

                    break;
                } else if (textolabel[i] == '-') {
                    resultado = modelo.Operaciones(operandos[0], operandos[1], "-");
                    result = String.valueOf(resultado);
                    c.getlbl().setText("");

                    if(!modelo.VerificarDobule(soporte)) {
                        resultadoInt = (int) Math.round(resultado);
                        result = String.valueOf(resultadoInt);
                        c.Resultado(result);
                    } else {
                        c.Resultado(result);
                    }
                    break;
                } else if(textolabel[i] == '*') {
                    resultado = modelo.Operaciones(operandos[0], operandos[1], "*");
                    result = String.valueOf(resultado);
                    c.getlbl().setText("");

                    if(!modelo.VerificarDobule(soporte)) {
                        resultadoInt = (int) Math.round(resultado);
                        result = String.valueOf(resultadoInt);
                        c.Resultado(result);
                    } else {
                        c.Resultado(result);
                    }

                    break;
                } else if(textolabel[i] == '/') {
                    resultado = modelo.Operaciones(operandos[0], operandos[1], "/");
                    if (operandos[0] == 0 || operandos[1] == 0) {
                        c.getlbl().setText("Error de sintaxsis");
                    } else {
                        result = String.valueOf(resultado);
                        c.getlbl().setText("");
                        c.Resultado(result);
                    }
                    break;
                } else if(textolabel[i] == '√') {
                    double resultad;
                    resultad = modelo.Operaciones(operandos[0]);
                    result = String.valueOf(resultad);
                    c.getlbl().setText("");
                    c.Resultado(result);
                    break;
                }  else {
                    c.getlbl().setText("Error de Sintaxis");
                }
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}



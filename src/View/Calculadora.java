package View;

import Controller.ControlCalculadora;
import Model.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;


public class Calculadora extends JFrame  {
    JPanel panel1;
    JLabel label;
    Color color;
    JPanel panel2;
    String[] simbolos = {"%","√","x2","1/x","CE","C","Delete","/","7","8","9","*","4","5","6","-","1","2","3","+","+-","0",".","="};
    JButton btn;
    Modelo modelo = new Modelo();

    public Calculadora () {
        Contenido();
        Iniciar();
    }

    void Iniciar () {
        setTitle("Calculadora");
        setSize(350,550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void Contenido() {
        color = new Color(60, 60, 60);
        getContentPane().setBackground(color);
        getContentPane().setLayout(null);


        panel1 = new JPanel();
        label = new JLabel("");

        label.setFont(new Font("Arial", Font.PLAIN, 25));
        label.setBackground(Color.white);
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        panel1.setLayout(null);
        label.setBounds(0,100,330,50);
        panel1.add(label);

        panel2 = new JPanel();

        panel2.setLayout(new GridLayout(6,4));


        ControlCalculadora control = new ControlCalculadora(this, new Modelo());

        for (int i = 0 ; i < simbolos.length; i++) {
            btn = new JButton(simbolos[i]);
            btn.addActionListener(control);
            btn.setFocusable(false);
            panel2.add(btn);
        }

        pack();

        panel1.setBounds(0,0,350,150);
        panel2.setBounds(0,151,335,360);

        getContentPane().add(panel1);
        getContentPane().add(panel2);
    }

    public void modificarLabel(String texto){
        if (texto == "") {
            label.setText(texto);
        } else if (texto == "√") {
            label.setText(texto+label.getText());
        } else {
            label.setText(label.getText()+texto);
        }

    }

    public void LimpiarDisplay(){
        label.setText("");
    }

    public void Resultado(String Texto){
        label.setText("");
        label.setText(Texto);
    }

    public JLabel getlbl() {
        return label;
    }

    public JButton getBtn () {
        return btn;
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
    }

}

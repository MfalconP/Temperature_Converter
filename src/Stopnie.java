import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Konwerter.*;

public class Stopnie {
    private static JTextField pole1;
    private static JTextField pole2;
    private static JButton przycisk;

    public static void frame(){
        JFrame ramka = new JFrame("Konwerter stopni");

        JLabel etykieta1 = new JLabel("Cels jusz");
        JLabel etykieta2 = new JLabel("Fahrenheit");
        przycisk = new JButton("Wyczyść Pola");
        pole1 = new JTextField(15);
        pole2 = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(3,2));

        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(etykieta1);
        panel.add(pole1);
        panel.add(etykieta2);
        panel.add(pole2);
        panel.add(przycisk);

        ramka.getContentPane().add(BorderLayout.CENTER, panel);

        przycisk.addActionListener(new buttonReaction());
        pole1.addActionListener(new field1Reaction());
        pole2.addActionListener(new field2Reaction());


        ramka.setSize(400,300);
        ramka.setResizable(false);
        ramka.setLocation(800,450);
        ramka.setVisible(true);
        ramka.pack();

    }
    static class buttonReaction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            pole1.setText(null);
            pole2.setText(null);
        }
    }
    static class field1Reaction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                double c = Double.parseDouble(pole1.getText());
                double f = Math.round(Konwerter.cToF(c));
                pole2.setText(String.valueOf(f));
            }
            catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Nieprawidłowy format liczby", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    static class field2Reaction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try{
                double f = Double.parseDouble(pole2.getText());
                double c = Math.round(Konwerter.fToC(f));
                pole1.setText(String.valueOf(c));
            }
            catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Nieprawidłowy format liczby", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }




    public static void main(String[] args) {
    frame();

    }
}




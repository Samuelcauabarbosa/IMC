import javax.swing.*;
import java.awt.event.*;

public class CalculadoraIMC extends JFrame {
    private JTextField campoPeso, campoAltura;
    private JLabel labelResultado;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        campoPeso = new JTextField(10);
        campoAltura = new JTextField(10);
        JButton botaoCalcular = new JButton("Calcular");

        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double peso = Double.parseDouble(campoPeso.getText());
                double altura = Double.parseDouble(campoAltura.getText()) / 100; // Converter altura para metros
                double imc = peso / (altura * altura);

                String resultadoIMC;
                if (imc < 18.5) {
                    resultadoIMC = "Abaixo do peso";
                } else if (imc < 25) {
                    resultadoIMC = "Peso normal";
                } else if (imc < 30) {
                    resultadoIMC = "Sobrepeso";
                } else {
                    resultadoIMC = "Obesidade";
                }

                labelResultado.setText(String.format("Seu IMC é %.2f. Classificação: %s", imc, resultadoIMC));
            }
        });

        labelResultado = new JLabel("");

        painel.add(new JLabel("Peso (Kg):"));
        painel.add(campoPeso);
        painel.add(new JLabel("Altura (cm):"));
        painel.add(campoAltura);
        painel.add(botaoCalcular);
        painel.add(labelResultado);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraIMC().setVisible(true);
            }
        });
    }
}

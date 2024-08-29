import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

public class Calculadora extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextField display;
    private double result = 0;
    private String operator = "";

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT); // Alinear el texto a la derecha
        display.setFont(new Font("Arial", Font.BOLD, 24)); // Aumentar el tamaño de la fuente
        display.setPreferredSize(new java.awt.Dimension(getWidth(), 60)); // Establecer un tamaño preferido
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4)); // 5 filas y 4 columnas

        // Orden personalizado de los botones
        String[] buttonOrder = {
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "0", "C", "=", "/"
        };

        for (String label : buttonOrder) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        } else if ("C".equals(command)) {
            display.setText("");
            result = 0;
            operator = "";
        } else if ("=".equals(command)) {
            double operand = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result /= operand;
                    } else {
                        JOptionPane.showMessageDialog(this, "División por cero no permitida", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }
            display.setText("" + result);
        } else {
            if (!display.getText().isEmpty()) {
                double operand = Double.parseDouble(display.getText());
                switch (command) {
                    case "+":
                        result = operand;
                        operator = "+";
                        break;
                    case "-":
                        result = operand;
                        operator = "-";
                        break;
                    case "*":
                        result = operand;
                        operator = "*";
                        break;
                    case "/":
                        result = operand;
                        operator = "/";
                        break;
                }
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.setVisible(true);
    }
}
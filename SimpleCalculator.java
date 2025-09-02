package COGNIFYZ_TECHNOLOGIES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener
 {
    private JTextField inputField;
    private double num1 = 0, num2 = 0;
    private char operator;

    public SimpleCalculator() 
    {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
      
        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setFont(new Font("Arial", Font.BOLD, 24));
        add(inputField, BorderLayout.NORTH);

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", "C", "=", "+"
        };

       
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') 
        {
            inputField.setText(inputField.getText() + cmd);
        } else if (cmd.equals("C"))
         {
            inputField.setText("");
            num1 = num2 = 0;
        } else if (cmd.equals("=")) 
        {
            try {
                num2 = Double.parseDouble(inputField.getText());
                double result = calculate(num1, num2, operator);
                inputField.setText(String.valueOf(result));
            } catch (Exception ex) 
            {
                inputField.setText("Error");
            }
        } else {
            try {
                num1 = Double.parseDouble(inputField.getText());
                operator = cmd.charAt(0);
                inputField.setText("");
            } catch (Exception ex)
            {
                inputField.setText("Error");
            }
        }
    }

    private double calculate(double a, double b, char op)
     {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return (b != 0) ? a / b : 0;
            default: return 0;
        }
    }

    public static void main(String[] args)
     {
        new SimpleCalculator();
    }
}

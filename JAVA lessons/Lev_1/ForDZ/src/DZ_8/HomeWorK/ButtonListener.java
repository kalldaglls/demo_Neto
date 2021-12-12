package DZ_8.HomeWorK;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ButtonListener implements ActionListener {
    private final JTextField jTextField;
    private final StringBuilder stringBuilder = new StringBuilder();

    public ButtonListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        //jButton.getText();
        stringBuilder.append(jTextField.getText()).append(jButton.getText());
        jTextField.setText(stringBuilder.toString());
        if (stringBuilder.toString().contains("-") && stringBuilder.toString().contains("=")) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String [] forMin = stringBuilder.toString().split("-");
            int intMin = parseInt(forMin[0]) - parseInt(forMin[1]);
            System.out.println(intMin);
            jTextField.setText(String.valueOf(intMin));
            //jTextField.setText("I SEE DEAD PEOPLE!");
        }

        else if (stringBuilder.toString().contains("*") && stringBuilder.toString().contains("=")) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String [] forMin = stringBuilder.toString().split("*");
            int intMul = parseInt(forMin[0]) * parseInt(forMin[1]);
            System.out.println(intMul);
            jTextField.setText(String.valueOf(intMul));
            //jTextField.setText("I SEE DEAD PEOPLE!");
        }

        else if (stringBuilder.toString().contains("/") && stringBuilder.toString().contains("=")) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String [] forMin = stringBuilder.toString().split("/");
            int intDup = parseInt(forMin[0]) / parseInt(forMin[1]);
            System.out.println(intDup);
            jTextField.setText(String.valueOf(intDup));
            //jTextField.setText("I SEE DEAD PEOPLE!");
        }
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }
}

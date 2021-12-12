package DZ_8.HomeWorK;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

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
            int checkPlus = 0;
            int checkMin = 0;
            int checkMul = 0;
            int checkDiv = 0;
            int checkRes = 0;
        System.out.println("Jtext = " + jTextField.getText());
        stringBuilder.append(jTextField.getText()).append(jButton.getText());
        jTextField.setText(stringBuilder.toString());
            for (int i = 0; i < jTextField.getText().length(); i++) {
                if (jTextField.getText().charAt(i) == '+') {
                    checkPlus++;
                }
            }
            for (int i = 0; i < jTextField.getText().length(); i++) {
                if (jTextField.getText().charAt(i) == '-') {
                    checkMin++;
                }
            }

            if (checkPlus > 1 || checkMin > 1) {
                System.out.println("ERROR!");
                jTextField.setText("ERROR! Press C!");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//                stringBuilder.append(jTextField.getText()).append(jButton.getText());
//                jTextField.setText(stringBuilder.toString());
//                stringBuilder.setLength(0);
//                ActionListener actionListener123 = new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        jTextField.setText("");
//                    }
//                };
//                jTextField.setText("");
//                stringBuilder.setLength(0);
//                stringBuilder.append(jTextField.getText()).append(jButton.getText());
//                jTextField.setText(stringBuilder.toString());
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
////
//                return;
            }
            //if(!jTextField.getText().contains("+") && !jTextField.getText().contains("=") && checkPlus <= 1) {
//            System.out.println("Jtext = " + jTextField.getText());
//            stringBuilder.append(jTextField.getText()).append(jButton.getText());
//            jTextField.setText(stringBuilder.toString());
            //do {
            if (stringBuilder.toString().contains("+") && stringBuilder.toString().contains("=") && checkPlus <= 1) {//Как упростить, чтобы сразу из стрингбилда брать, а не через тустринг?
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);//это тоже бред!
                String[] forPlus = stringBuilder.toString().split("\\+");
                int intplus = parseInt(forPlus[0]) + parseInt(forPlus[1]);
                System.out.println(intplus);
                jTextField.setText(String.valueOf(intplus));
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
               // return;
                //jTextField.setText("I SEE DEAD PEOPLE!");
            } else if (stringBuilder.toString().contains("-") && stringBuilder.toString().contains("=")) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                String[] forMin = stringBuilder.toString().split("-");
                int intMin = parseInt(forMin[0]) - parseInt(forMin[1]);
                System.out.println(intMin);
                jTextField.setText(String.valueOf(intMin));
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
                //return;
                //jTextField.setText("I SEE DEAD PEOPLE!");
            } else if (stringBuilder.toString().contains("*") && stringBuilder.toString().contains("=")) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                String[] forMul = stringBuilder.toString().split("\\*");
                int intMul = parseInt(forMul[0]) * parseInt(forMul[1]);
                System.out.println(intMul);
                jTextField.setText(String.valueOf(intMul));
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
                //return;
                //jTextField.setText("I SEE DEAD PEOPLE!");
            } else if (stringBuilder.toString().contains("/") && stringBuilder.toString().contains("=")) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                String[] forDup = stringBuilder.toString().split("/");
                int intDup = parseInt(forDup[0]) / parseInt(forDup[1]);
                System.out.println(intDup);
                jTextField.setText(String.valueOf(intDup));
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
               // return;
                //jTextField.setText("I SEE DEAD PEOPLE!");
            }
            System.out.println(stringBuilder);
            stringBuilder.setLength(0);
        }
          //  }
//            else{
//            System.out.println("ERROR!");
//            jTextField.setText("ERROR!".toString());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            stringBuilder.setLength(0);
//            jTextField.setText("");
//            return;
//        }
        }


       // }while (!stringBuilder.toString().contains("+"));


//    public boolean notEmptyAction() {
//        if()
//    }


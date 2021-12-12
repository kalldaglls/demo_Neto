package DZ_8.HomeWorK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form_1 extends JFrame {
    public Form_1(String title){
        setTitle(title);
        setBounds(50,30,300,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        setLayout(new GridLayout(2,2));
//        for (int i = 1; i <= 4; i++) {
//            JPanel jPanel2 = new JPanel();
//            jPanel2.setBackground(new Color(57 * i, i * 10,42 - (i * 5)));
//            add(jPanel2);
//        }
//
//        setVisible(true);
//
//        if(true) return;

        //setLayout(new GridLayout(4,3));

        setLayout(new GridLayout(2,1));

        JTextField jTextField = new JTextField();//Однострочная компонента - можем записывать только одну строку!
        jTextField.setEditable(false);

        ButtonListener buttonListener = new ButtonListener(jTextField);

        JPanel jPanel1 = new JPanel(new GridLayout(5,3));
        jPanel1.setBackground(new Color(24,87,157));
        JScrollPane jScrollPane = new JScrollPane(jPanel1);

        for (int i = 0; i <= 9; i++) {
            JButton digits = new JButton(String.valueOf(i));
            digits.setBackground(new Color(80 + (i * 10),50 + (i * 15),174 + i));
            digits.addActionListener(buttonListener);
            jPanel1.add(digits);
        }

        JButton plus = new JButton(String.valueOf('+'));
        JButton minus = new JButton(String.valueOf('-'));
        JButton multiple = new JButton(String.valueOf('*'));
        JButton divide = new JButton(String.valueOf('/'));
        JButton clear = new JButton(String.valueOf('C'));
        plus.addActionListener(buttonListener);
        minus.addActionListener(buttonListener);
        multiple.addActionListener(buttonListener);
        divide.addActionListener(buttonListener);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
            }
        });


        //add(submit);
        jPanel1.add(plus);
        jPanel1.add(minus);
        jPanel1.add(multiple);
        jPanel1.add(divide);
        jPanel1.add(clear);


        JPanel jPanel = new JPanel(new BorderLayout());
        JButton submit = new JButton(String.valueOf("="));
        submit.addActionListener(buttonListener);
        jPanel.setBackground(new Color(200,200,50));
        jPanel.add(jTextField, BorderLayout.CENTER);
        jPanel.add(submit, BorderLayout.EAST);

        add(jPanel1);
        add(jPanel);
        add(jScrollPane, BorderLayout.SOUTH);
        //add(new JScrollPane());

        setVisible(true);
    }
}

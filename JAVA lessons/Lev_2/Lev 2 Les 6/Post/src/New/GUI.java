package New;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame {
    private Client client;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        JTextArea jTextArea = new JTextArea();
        client = new Client(jTextArea);
        setTitle("Chat for Serega!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setBounds(new Rectangle(0,0,300,500));

        setLayout(new BorderLayout());

        jTextArea.setEditable(false);
        add(jTextArea,BorderLayout.CENTER);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        //add(jPanel, BorderLayout.SOUTH);

        JTextField jTextField = new JTextField();
        JButton submitButton = new JButton();
        submitButton.setText("PUSH IT!!!");//Как сделать так, чтоюы PUSH IT работала при нажатии Enter?
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String newMessage = jTextField.getText();
               if(!newMessage.trim().isBlank()) {
                   try {
                       client.getOuts().writeUTF(newMessage);
                       jTextField.setText("");
                   } catch (IOException ioException) {
                       ioException.printStackTrace();
                   }
               }
            }
        });

        jPanel.add(jTextField, BorderLayout.CENTER);
        jPanel.add(submitButton, BorderLayout.EAST);

        add(jPanel, BorderLayout.SOUTH);//Без этого jTextField не отображалось
        setVisible(true);
    }
}

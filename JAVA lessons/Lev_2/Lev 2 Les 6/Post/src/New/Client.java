package New;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private DataInputStream ins;
    private DataOutputStream outs;
    private JTextArea chatArea;

    public DataInputStream getIns() {
        return ins;
    }

    public DataOutputStream getOuts() {
        return outs;
    }

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
    }

    public Client(JTextArea chatArea) {
        this.chatArea = chatArea;
        try {
            Socket socket = new Socket("localhost", 18443);// Как этот socket соотносится с socket в классе Server?
            System.out.println("Client info: " + socket);

            ins = new DataInputStream(socket.getInputStream());
            outs = new DataOutputStream(socket.getOutputStream());

            //Если оставлял строки ниже, то GUI работал криво с сервером!
            /*
            outs.writeUTF("Some message!");//Отправляем первое сообщение серверу!
            outs.writeUTF("and New message!");
             */

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = ins.readUTF();
                            chatArea.append(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            /*
            while(true) {
                String message = ins.readUTF();
                System.out.println(message);
            }
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

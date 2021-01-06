package ClientTest;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {

    private DataInputStream ins;
    private DataOutputStream outs;

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
        try {
            Socket socket = new Socket("localhost", 8843);
            System.out.println("Client info: " + socket);

            ins = new DataInputStream(socket.getInputStream());
            outs = new DataOutputStream(socket.getOutputStream());

            outs.writeUTF("2");//Отправляем первое сообщение серверу!
            //outs.write("New File".getBytes(StandardCharsets.UTF_8));
            //byte[] fileContent = Files.readAllBytes(Paths.get("C:\\Users\\Тереза\\Desktop\\JAVA lessons\\Q2\\Облачное хранилище\\Реп\\Cloud\\CheckSave.txt"));
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Тереза\\Desktop\\JAVA lessons\\Q2\\Облачное хранилище\\Реп\\Cloud\\CheckSave.txt");
            outs.write(fileInputStream.readAllBytes());
            //outs.flush();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = ins.readUTF();
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

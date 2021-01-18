import java.io.*;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        new client();
    }

    public client(){
        try {
            Socket socket = new Socket("localhost", 8845);
            System.out.println("Client info: " + socket);
            InputStream ins;
            OutputStream ous;
            ins = new FileInputStream(
            "C:\\Users\\Тереза\\Desktop\\JAVA lessons\\Q2\\Облачное хранилище\\Реп\\cloud-storage\\transfer.txt");
            ous = new BufferedOutputStream(socket.getOutputStream());
            int fromClient;
            while ((fromClient = ins.read()) != -1) {
                ous.write(fromClient);
            }
            System.out.println("Server, receive the message, please!!!");
            ins.close();
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

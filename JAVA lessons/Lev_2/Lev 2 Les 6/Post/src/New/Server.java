package New;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataInputStream ins;
    private DataOutputStream outs;
    public static void main(String[] args) {

        new Server();

    }

    public Server(){//Это конструктор?
        try {
            System.out.println("Server is starting up!");
            ServerSocket serverSocket = new ServerSocket(18443);
            System.out.println("Waiting for connection!");
            Socket socket = serverSocket.accept();//Создаем "экземпляр" клиента
            System.out.println("Client connected: " + socket);

            ins = new DataInputStream(socket.getInputStream());
            //System.out.println(ins);
            outs = new DataOutputStream(socket.getOutputStream());

            while(true) {//Здесь как бы ставим ограничитель по кол-ву сообщений!
                String message = ins.readUTF();
                outs.writeUTF("Client, I've heard " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

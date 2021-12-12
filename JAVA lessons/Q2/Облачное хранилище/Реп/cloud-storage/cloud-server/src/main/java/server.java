import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public server() {
        //ServerSocket serverSocket = null;
        try {
           ServerSocket serverSocket = new ServerSocket(8845);
            System.out.println("Waiting for connection!");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);
            InputStream ins;
            DataOutputStream ous;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

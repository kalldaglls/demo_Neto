package ClientPart;

import java.io.IOException;
import java.net.Socket;

public class ClientAplication1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

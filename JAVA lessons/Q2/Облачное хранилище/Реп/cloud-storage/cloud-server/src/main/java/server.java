import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        new server();
    }

    public server() {
        //ServerSocket serverSocket = null;
        try {
           ServerSocket serverSocket = new ServerSocket(8845);
            System.out.println("Waiting for connection!");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);
            InputStream ins;
            OutputStream ous;

            ins = new BufferedInputStream(socket.getInputStream());
            //ous = new FileOutputStream(
            // "C:\\Users\\Тереза\\Desktop\\JAVA lessons\\Q2\\Облачное хранилище
            // \\Реп\\cloud-storage\\cloud-server"); В доступе здесь отказано! FileNotFoundException
            File file = new File("C:\\Users\\Тереза\\Desktop\\JAVA lessons\\Q2\\Облачное хранилище\\Реп\\cloud-storage", ins.getClass().getName());
            ous = new FileOutputStream(file);
            //ous = new ByteArrayOutputStream();
            System.out.println(file.getName());
            int nRead;
            //byte[] data = new byte[1024];

            while ((nRead = ins.read()) != -1) {
                ous.write(nRead);
                System.out.println(nRead);
                //System.out.println("Next");
            }

            //System.out.println(ous.getClass().getName());

            ins.close();
            ous.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

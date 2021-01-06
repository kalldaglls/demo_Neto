import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class InetAddressTest {
        public static void main(String[] args) throws IOException {
            new InetAddressTest();
        }

    public InetAddressTest() throws IOException {//Здесь все является потоками(4-5 шт) и их всех нужно закрыть?
        ServerSocket serverSocket = new ServerSocket(8433);

        System.out.println("Server is waiting for client...");

        Socket socket = serverSocket.accept();

        System.out.println(socket);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(inputStream, "UTF-16");

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-16"), true);

        printWriter.println("Hello! Enter QUIT to exit!");

        boolean done = false;

        while(!done && scanner.hasNextLine()) {
            printWriter.println("Inside loop!");
            String line = scanner.nextLine();
            printWriter.println(String.format("Message for client # %s: %s",socket.getPort(),line));
            if (line.trim().equals("QUIT")) {
                done = false;
                return;//без этого не отключался!
            }
        }

    }
}

package service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileServer {
    final private static String DIR = "C:\\Users\\Тереза\\Desktop\\JAVA lessons\\Q2\\Облачное хранилище\\Реп\\DB";



    public FileServer() {
        DataOutputStream outs = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8845);
            System.out.println("Waiting for connection!");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);
            DataInputStream ins = new DataInputStream(socket.getInputStream());
            outs = new DataOutputStream(socket.getOutputStream());

            outs.writeUTF("Commands: 1. Get file list");
            outs.writeUTF("Commands: 2. Save file");
            String message = ins.readUTF();//Работает ли это как scanner.nextLine?
            outs.writeUTF(message);
            if(message.contains("1")) {
                outs.writeUTF(getFileList().toString());
            }
            if(message.equals("2")) {
                try (BufferedInputStream bins = new BufferedInputStream(socket.getInputStream())) {

                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    int nRead;//Почему, если здесь я присваиваю nRead = ins.read(), то в цикле значение не меняется?
                    byte[] data = new byte[1024];
                    //System.out.println("первый" + ins.read());

                    while ((nRead = bins.read()) != -1) {//Может ли он быть равен -1?
                        buffer.write(nRead);
                        System.out.println(nRead);
                        System.out.println("Next");
                    }
                    System.out.println("No breakpoint 2?");
                    String name = "File #1.txt";
                    saveFile(buffer.toByteArray(),name);
                    outs.writeUTF("File saved");
                }

                /*
                System.out.println("No breakpoint?");
                System.out.println(Arrays.toString(ins.readAllBytes()));
                byte [] bytes = socket.getInputStream().readAllBytes();
                 */
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {//Почему здесь мы можем писать разные типы исключений?
            if(outs != null) {
                try {
                    outs.writeUTF("Operation failed");
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getFileList();
    }
    public static List<String> getFileList () {
        List<String> fileList = new ArrayList<>();
        final File folder = new File(DIR);
        for (final File fileEntry : folder.listFiles()) {
            fileList.add(fileEntry.getName());
        }
        return fileList;
    }

    public void saveFile (byte [] array, String name) throws IOException {
        File newFile = new File(
                DIR,
                name);//Как создать файл именно txt-формата и присвоить ему name?
        System.out.println(newFile.getName());
        System.out.println(newFile.getPath());


        try(FileOutputStream fout = new FileOutputStream(newFile, true)) {
            fout.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newFile);
    }


}

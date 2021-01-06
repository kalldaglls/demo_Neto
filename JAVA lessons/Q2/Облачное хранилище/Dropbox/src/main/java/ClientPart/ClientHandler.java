package ClientPart;

import DataBase.AuthenticationService;
import ServerPart.ServerCloud;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private String name;
    private Socket socket;//Как этот сокет взаимодействует с сокетом на сервере?
    private DataInputStream ins;
    private DataOutputStream outs;
    private ServerCloud serverCloud1; // Как создать экземпляр этого класса, если будет отдельный модуль/программа?

    public ClientHandler(Socket socket, ServerCloud serverCloud1) {//Грохнул ins и outs
        //this.name = name;
        this.socket = socket;
        try {
            this.ins = new DataInputStream(socket.getInputStream()); //как до этого додуматься?
            this.outs = new DataOutputStream(socket.getOutputStream());
            startClientHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.serverCloud1 = serverCloud1;
    }

    public void startClientHandler() {//Делаем пробел между названием метода и ()?
        new Thread(new Runnable() {// Может здесь не читаем, а получаем файлы и сообщения от сервера(для облака)?
           @Override// Что за -> в строке выше???
           public void run() {
                while (true) {
                    try {
                        readTheMessage();
                        authenticate();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        closeConnection();
                    }
                    }
                    //serverCloud1.broadcast();
                }

        }).start();

    }

    public void authenticate() {
        while(true) {
            try {
                String loginInfo = ins.readUTF();
                if (loginInfo.startsWith("-auth")) {
                    // -auth l1 p1
                    String [] splitedDataInfo = loginInfo.split("\\s");
                    // Как работает строка ниже?
                   AuthenticationService.ClientData maybeClient = serverCloud1.getAuthenticationService().findByLogAndPass(
                            splitedDataInfo[1],
                            splitedDataInfo[2]
                );
                   if (maybeClient != null) {
                        if(serverCloud1.checkLogin(maybeClient.getName())) {
                            sendTheMessage("status auth OK!");
                            name = maybeClient.getName();
                            serverCloud1.broadcast(String.format("%s has logged in", name));
                            serverCloud1.subscribe(this);
                        } else {
                            sendTheMessage(String.format("%s has already logged in!",maybeClient.getName()));
                        }
                   } else {
                       sendTheMessage("Incorrect credentials!");
                   }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() {
        serverCloud1.unsubscribe(this);
        serverCloud1.broadcast(String.format("%s has left", name));
        try {
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTheMessage () throws IOException{
            while (true) {
                String message1 = ins.readUTF();//Получаем сообщение. От кого? От других юзеров или от сервера?
                // message1 = "Where are you?";//Сделаем для этого main?
                String formattedMessage1 = String.format("Incoming message from %s: %s", name, message1);
                System.out.println(formattedMessage1); //В чью консоль вывод? Почему name у нас фиолетовое?
                if (message1.equals("-exit")) { //Делаем выход из чата
                    return;
                }
                serverCloud1.broadcast(formattedMessage1);
            }
    }

    public void sendTheMessage (String message1) {// Как понять, когда можем выбрасывать exception, а не try/catch?
        try {
            outs.writeUTF(message1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}

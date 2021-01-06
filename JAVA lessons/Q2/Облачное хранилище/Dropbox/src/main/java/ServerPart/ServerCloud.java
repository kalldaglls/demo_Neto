package ServerPart;

import ClientPart.ClientHandler;
import DataBase.AuthenticationService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerCloud {
    private Set<ClientHandler> clientHandlerSet;//Делаем Set, чтобы юзеры были уникальными.
    private AuthenticationService authenticationService;

    public ServerCloud() {//Опять грохнул параметр!
        this.clientHandlerSet = new HashSet<>();//Как это придумать?Как работают конструкторы?
        this.authenticationService = new AuthenticationService();
        start(8000);// Как здесь можно так делать?!
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    private void start(int port) {//Создаем метод, который запускает сервер
            try (ServerSocket serverSocket1 = new ServerSocket(port)) { //Делаем экземпляр класса, который требует Closeable - для этого делаем try with resources
                searchForAClient(serverSocket1);
            } catch (IOException e) {
                throw new RuntimeException("Something went wrong during server start up");
            }
        }

        private void searchForAClient (ServerSocket serverSocket1) {
            while (true) {
                System.out.println("Server is looking for a new client");
                try {
                    //Ищем клиента и ассептим его
                    Socket client1 = serverSocket1.accept();//опять же - как связан с классом ClientHandler?
                    System.out.println("Client accepted " + client1);
                    new ClientHandler(
                            client1,
                            this
                    );
                    //subscribe(clientHandler);
                   // clientHandlerSet.add(clientHandler);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void broadcast(String incomingMessage1) {//Отправляем всем юзерам сообщение
            for (ClientHandler ch:clientHandlerSet) {
                ch.sendTheMessage(incomingMessage1);//Как это работает?
            }
        }

        public void subscribe(ClientHandler user) {
            clientHandlerSet.add(user);
        }

    public void unsubscribe(ClientHandler user) {
        clientHandlerSet.remove(user);
    }

    public boolean checkLogin(String name) {
        for (ClientHandler ch : clientHandlerSet) {
                if (ch.getName().equals(name)) {
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerCloud that = (ServerCloud) o;
        return Objects.equals(clientHandlerSet, that.clientHandlerSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientHandlerSet);
    }

    public void testServ() {
            System.out.println("Do you see this message?");
        }
}

import ClientPart.ClientHandler;
import ServerPart.ServerCloud;

public class MainLauncher1 {
    public static void main(String[] args) {//Отдельно mainы нужны для наших сервера и хэндлера?
        new ServerCloud();//Не дает использовать private методы своего класса - как это сделать?
        //new ClientHandler();
    }
}


package DataBase;

import java.util.HashSet;
import java.util.Set;

public class AuthenticationService {//Наша БД с данными юзеров?
    private Set<ClientData> clients;

    public AuthenticationService() {//БД юзеров
        clients = Set.of(
                new ClientData("l1", "p1", "u1"),
                new ClientData("l2", "p2", "u2"),
                new ClientData("l3", "p3", "u3")
        );
    }

    public ClientData findByLogAndPass(String login, String password) {//Проверка совпадения данных
        for (ClientData c: clients) {
            if(c.getLogin().equals(login) && c.getPassword().equals(password)){
                return c;
            }
        }
        return null;
    }

    static public class ClientData {//Класс инфы юзера
        private String login;
        private String password;
        private String name;

        public ClientData(String login, String password, String name) {
            this.login = login;
            this.password = password;
            this.name = name;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

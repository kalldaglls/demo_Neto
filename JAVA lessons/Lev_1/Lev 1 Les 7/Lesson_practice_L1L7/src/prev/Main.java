package prev;

public class Main {

    public static void main(String[] args) {
        new animal().count1();
        new animal().count1(99);
        new animal().count1(199);
        new animal().count1(99,199);
        new animal().count1(1,1.5);//он всегда поймет, какой метод я хочу исползовать?
    }
}

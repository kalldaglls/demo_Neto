package New1;

public class StringMethods {
    public static void main(String[] args) {
        String strNew1 = "cuc kold";
        System.out.println(strNew1.isBlank());
        System.out.println("     ".isBlank());
        System.out.println("     a".isBlank());
        System.out.println(strNew1.length());
        System.out.println("Kelvin!!!".length());

        doStringBildDemo();
    }

    static void doStringBildDemo() {
        StringBuilder stringBuilder = new StringBuilder("A");
        stringBuilder.append("BCDEF");
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i);
        }
        System.out.println(stringBuilder);
        stringBuilder.append("END");
        System.out.println(stringBuilder);
        stringBuilder.setLength(6);
        System.out.println(stringBuilder);

    }
}

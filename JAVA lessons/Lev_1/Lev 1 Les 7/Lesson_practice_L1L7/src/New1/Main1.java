package New1;

public class Main1 {
    public static void main(String[] args) {
       /*
        lowregister lowregister = new lowregister();
        System.out.println(lowregister);
        String str1 = "123";
        String str2 = new String("123");
        System.out.println(str1.equals(str2));
        Integer integer1 = 2;
        */
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);

        EqualsTester equalsTester1 = new EqualsTester(799);
        EqualsTester equalsTester2 = new EqualsTester(799);
        System.out.println("Tester " + equalsTester1.equals(equalsTester2));

        EqualsCrasher equalsCrasher = new EqualsCrasher(799);
        System.out.println("Crash " + equalsTester1.equals(equalsCrasher));

        char [] symbols = s1.toCharArray();
        System.out.println(symbols);

        char forl = 0x6C;
        char for0 = 0;
        char forshift = 0x1C;
        char greek1 = '\u03B6';
        System.out.println(forl);
        System.out.println(for0);
        System.out.println(forshift);
        System.out.println((char) 126);
        System.out.println(greek1);
    }
}

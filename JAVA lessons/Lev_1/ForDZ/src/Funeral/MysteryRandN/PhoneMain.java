package Funeral.MysteryRandN;

import java.util.HashMap;

public class PhoneMain {
    public static void main(String[] args) {
        HashMap<String,Integer> oldPhoneBook = new HashMap<>();
        oldPhoneBook.put("Antonov",5557555);
        oldPhoneBook.put("Antonov",7785569);
        oldPhoneBook.put("Kirilov",8796248);
        oldPhoneBook.put("Dubkin",2555824);
        oldPhoneBook.put("Pavlov",1050027);
        oldPhoneBook.put("Kirilov",5887544);
        PhoneBook phoneBook1 = new PhoneBook(oldPhoneBook);
        System.out.println(phoneBook1.get("Dubkin"));
        System.out.println(phoneBook1.get("Antonov"));
    }
}

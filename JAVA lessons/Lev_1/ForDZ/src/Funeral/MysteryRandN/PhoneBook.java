package Funeral.MysteryRandN;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
//В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
//искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//(в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
//Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
//взаимодействие с пользователем через консоль и т.д).
//Консоль использовать только для вывода результатов проверки телефонного справочника.
public class PhoneBook implements Comparable{
    private HashMap<String,Integer> telHashMap;

    public PhoneBook() {
    }

    public PhoneBook(HashMap<String, Integer> telHashMap) {
        this.telHashMap = telHashMap;
    }

    public void add(String name, Integer number){
//        if(this.telHashMap.containsKey(name)){
//            Iterator<String> iterator1 = telHashMap.;
//        }
        this.telHashMap.put(name, number);
    }

    public Integer get(String name){
        return this.telHashMap.get(name);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(telHashMap, phoneBook.telHashMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telHashMap);
    }
}

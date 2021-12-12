package Funeral.MysteryRandN;

import java.util.ArrayList;
import java.util.HashSet;

//Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
//из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
public class DZMain_2_3_Met {
    public static void main(String[] args) {
        String[] words = new String[]{"apple", "orange", "lemon", "broccoli", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "nut", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "nut", "pepper", "pineapple", "pumpkin", "pumpkin"};

        HashSet<String> noDubl = new HashSet<>();

//        String [] newWords = new String[]{};
//        StringBuilder stringBuilder1 = new StringBuilder();
        ArrayList<String> newArr = new ArrayList<>();

        for (String o: words) {
            if (noDubl.contains(o)) {
                System.out.println(o + " дубль!");
                newArr.add(o);
            }
            noDubl.add(o);
        }

        System.out.println(noDubl);
        //System.out.println(Arrays.toString(noDubl.toArray())); Не работает!!!
        System.out.println(newArr);

    }
}

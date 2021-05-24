package DZ_2;

import java.util.Arrays;
import java.util.Random;

public class DZ_2_1 {
    public static void main(String[] args) {
        int [] _2_5_array = {2,2,5,2,2,5,2,2,5,5,5,5};

        int [] emptyArray = new int[8];

        int [] checkHight = new int[]{1, -45, 0, 5, 3, 2, 11, 4, -52, 2, 4, 110, 9, 1};

        int [][] squareArray = new int[4][4];

        int [] summ = new int[]{1,1,2,2,3,3};

        int [] summ1 = new int[]{1, 1, 1, 1, 2, 2, 2, 1, 2, 2, 10, 1, 1, 3};

        int [] changeableArr = {1,2,3,4,5};

        // switchArrayElements(_2_5_array);

        //fillArray(emptyArray);

        //multipyArrayElements(checkHight);

        //fillDiagForArray(squareArray);

        //fillDiagonalEl();

       // findMinMaxEl(checkHight);

        //System.out.println(checkSumm(summ));

        //System.out.println(checkSumm(summ1));

        changePlace(changeableArr,2);

        changePlace(checkHight, 2);
    }

    public static void switchArrayElements(int [] a){
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 2) {
                a[i] = 5;
            }
            else a[i] = 2;//Хотел без else прописать - просто присваивал КАЖДОМУ элементу значение 2!:(
        }
        System.out.println(Arrays.toString(a));
    }

    public static void fillArray(int [] b) {
        int [] c = {0,3,6,9,12,15,18,21};
        if(b.length == 8) {
            for (int i = 0; i < b.length; i++) {//Idea предлагает System.arraycopy(c, 0, b, 0, b.length);
                b[i] = c[i];
            }
            System.out.println(Arrays.toString(b));
        }
        else System.out.println("Wrong length of array!");
    }

    public static void multipyArrayElements(int [] b){//В чем соль?
        for (int i = 0; i < b.length; i++) {
            if(b[i] < 6) {
                b[i] = b[i] * 2;
            }
        }
        System.out.println(Arrays.toString(b));
    }

    public static void fillDiagForArray(int [][] b) {
        Random random = new Random(1);
        for (int i = 0; i <= b.length; i = i + b.length - 1) {
            for (int p = 0; p < b[i].length; p = p + b[i].length){
                b[i][p] = random.nextInt(10);
                System.out.print("[" + b[i][p] + "]");
            }
            System.out.println();
        }
    }

    static void fillDiagonalEl() {//Как сделать круче?
        int[][] numbers = {
                {0, -82, 91, 112, 0},
                {0, -82, 91, 112, 0},
                {0, -82, 91, 112, 0},
                {0, -82, 91, 112, 0},
                {0, -82, 91, 112, 0}
        };
        for (int i = 0; i < numbers.length; i++) {
            numbers[i][i] = 1;
            numbers[i][numbers.length -1 - i] = 1;
        }
        System.out.println(Arrays.deepToString(numbers));
    }

    public static void findMinMaxEl(int [] b) {
        int min = b[0];
        int max = b[0];
        for (int i = 1; i < b.length; i++) {
            if(min > b[i]) {
                min = b[i];
            } else if (max < b[i]) {
                max = b[i];
            }
        }
        System.out.println("min = " + min + ", max = " + max);
    }

    public static boolean checkSumm(int [] b) {//Как сделать, чтобы исключения не впускать?
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum = sum + b[i];
        }
        int minusSum = 0;
        for (int i = 0; i < b.length; i++) {
            if (minusSum == sum) {
                System.out.println("true after " + i + " element" + ", sum = " + sum);
                return true;
            } else {
                sum = sum - b[i];
                minusSum = minusSum + b[i];
                System.out.println("sum=" + sum);
                System.out.println("minusSum=" + minusSum);
            }
        }
        return false;
    }

    public static void changePlace(int [] b, int n) {

        int a = b[0];
        for (int i = 0; i < b.length; i++) {
            if (i == b.length -1) {
                b[i] = a;
                System.out.println(Arrays.toString(b));
                System.out.println(n);
                break;
            }
            b[i] = b[i + 1];
        }
    }
}

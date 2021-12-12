package DZ_7.HomeWork;

public class Plate {
    private int food;
    private int number;

    public Plate(int food, int number) {
        this.food = food;
        this.number = number;
    }

    public boolean decreaseFood(int n) {//Большой плюс - сделал decreaseFood булейным и работал с ним в Cat правильно!
        if(food < n) {
            System.out.println("Not enough food in " + this);
            return false;
        }
        System.out.println(this + " is being eat!");
        food -= n;
        return true;
    }

    public void addFood(){
            food = food + 50;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    @Override
    public String toString() {
        return "Plate " +
                "№" + number;
    }
}

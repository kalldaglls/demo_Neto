package DZ_7.HomeWork;

public class Plate {
    private int food;
    private int number;

    public Plate(int food, int number) {
        this.food = food;
        this.number = number;
    }

    public void decreaseFood(int n) {
        if(food < n) {
            System.out.println("Not enough food in " + this);
            return;
        }
        addFood();
        System.out.println(this + " is being eat!");
        food -= n;
    }

    public void addFood(){
        if(food <= 0){
            food = food + 50;
        }
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

package DZ_7.HomeWork;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {//Макс предложил, чтобы здесь возвращал булиан - умно!
      if(p.decreaseFood(appetite)) {
          satiety = true;//Спорно!
          System.out.println(this);
      }
      else {
          System.out.println("{Дела ведем у кота в методе!] \n" + this + " doesn't have enough food to eat! ");//Мини-мини-плюс - вспомнил и вставил перенос строки!
      }
        p.info();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}

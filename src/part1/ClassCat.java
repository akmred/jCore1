package part1;/*
* Класс кошка
*
* */

public class ClassCat implements MoveJump {
    private String name;

    public ClassCat(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("cat " + this.name  + " run\n");
    }

    @Override
    public void jump() {
        System.out.printf("cat " + this.name  + " jump\n");

    }
}

package part1;/*
* Класс робот
*
* */

public class ClassRobot implements MoveJump {
    private  String name;

    public ClassRobot(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.printf("robot " + this.name  + " run\n");

    }

    @Override
    public void jump() {
        System.out.printf("robot " + this.name  + " jump\n");

    }
}

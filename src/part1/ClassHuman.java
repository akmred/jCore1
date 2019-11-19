package part1;

/*
* Класс человек
* */
public class ClassHuman implements MoveJump{

    private String name;

    public ClassHuman(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("human " + this.name  + " run\n");
    }

    @Override
    public void jump() {
        System.out.printf("human " + this.name  + " jump\n");
    }
}

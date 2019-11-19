package part1;

public class MainClass {

    public static void main(String[] args) {
        System.out.printf("hello world!\n");

        ClassCat cat = new ClassCat("Vasiliy");
        ClassHuman human = new ClassHuman("Sergey");
        ClassRobot robot = new ClassRobot("Repa");

        cat.run();
        human.jump();
        robot.run();

    }

}

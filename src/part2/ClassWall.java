package part2;

public class ClassWall implements InterfaceAct {
    private int height;

    public ClassWall(int height) {
        this.height = height;
    }

    public void jump(ClassSportsmens sportsmen){

        int limit_jump = sportsmen.getLimit_jump();
        String name = sportsmen.getName();

        if (sportsmen.isLost_the_race())
            System.err.printf("клиент: " + name + " снят с дистанции!!!\n");
        else if (limit_jump >= height)
            System.out.print(name + " jump distances: " +  limit_jump + "\n");
        else{
            System.err.print(name + " no jump distances " + limit_jump + "\n");
            sportsmen.setLost_the_race(true);
        }
    }

    @Override
    public void act(ClassSportsmens sportsmen) {
        jump(sportsmen);
    }
}

package part2;

public class ClassTreadmill implements InterfaceAct {
    private int long_distances;

    public ClassTreadmill(int long_distances) {
        this.long_distances = long_distances;
    }

    public void run(ClassSportsmens sportsmen){

        int limit_run = sportsmen.getLimit_run();
        String name = sportsmen.getName();

        if (sportsmen.isLost_the_race())
            System.err.print("клиент: " + name + " снят с дистанции!!!" + "\n");
        else if (limit_run >= long_distances)
            System.out.print(name + " run distances: " +  long_distances + "\n");
        else{
            System.err.print(name + " no run distances " + long_distances + "\n");
            sportsmen.setLost_the_race(true);
        }
    }

    @Override
    public void act(ClassSportsmens sportsmen) {
        run(sportsmen);
    }
}

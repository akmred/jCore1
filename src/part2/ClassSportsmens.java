package part2;

public class ClassSportsmens {
    private int limit_run, limit_jump;
    private boolean lost_the_race;
    private String name;

    public ClassSportsmens(String name, int limit_run, int limit_jump) {
        this.limit_run = limit_run;
        this.limit_jump = limit_jump;
        this.name = name;
    }

    public void setLimit_run(int limit_run) {
        this.limit_run = limit_run;
        this.lost_the_race = false;
    }

    public void setLimit_jump(int limit_jump) {
        this.limit_jump = limit_jump;
        this.lost_the_race = false;
    }

    public void setLost_the_race(boolean lost_the_race) {
        this.lost_the_race = lost_the_race;
    }

    public int getLimit_run() {
        return limit_run;
    }

    public int getLimit_jump() {
        return limit_jump;
    }

    public String getName() {
        return name;
    }

    public boolean isLost_the_race() {
        return lost_the_race;
    }
}

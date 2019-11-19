package part3_enums;

public enum DayOfWeek {
    Monday(false, 8), Tuesday(false, 8), Wednesday(false, 8),
    Thursday(false, 8), Friday(false, 8),
    Saturday(true, 0), Sunday(true, 0);

    // Это выходной
    private boolean isOutput;
    private int workHour;

    DayOfWeek(boolean isOutput, int workHour) {
        this.isOutput = isOutput;
        this.workHour = workHour;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public int getWorkHour() {
        return workHour;
    }
}

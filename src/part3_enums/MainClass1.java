/*
* 5. Решить задание с Enum, (дополнительно, задание прикреплено к материалам)
Требуется реализовать enum DayOfWeek, который будет представлять дни недели.
С его помощью необходимо решить задачу определения кол-ва рабочих часов до конца недели по заднному текущему дню.
Возвращает кол-во оставшихся рабочих часов до конца
 недели по заданному текущему дню. Считается, что
 текущий день ещё не начался, и рабочие часы за него
 должны учитываться.
 Если заданный день выходной то вывести "Сегодня выходной"
public class DayOfWeekMain {

 public static void main(String[] args) {
 System.out.println(getWorkingHours(DayOfWeek.MONDAY));
 }

* */

package part3_enums;

public class MainClass1 {

    public static void main(String[] args) {

        System.out.println(getWorkingHours(DayOfWeek.Monday));
        System.out.println(getWorkingHours(DayOfWeek.Friday));
        System.out.println(getWorkingHours(DayOfWeek.Saturday));
    }

    static int getWorkingHours(DayOfWeek dayOneOfWeek) {
        int count_hour = 0;

        if(dayOneOfWeek.isOutput())
            System.out.printf("Сегодня выходной! \n");
        else {
            DayOfWeek[] day = DayOfWeek.values();

            for (int i = dayOneOfWeek.ordinal(); i < day.length; i ++ ){
                count_hour = count_hour + day[i].getWorkHour();
            }
            System.out.printf("количество часов до конца недели: " );
        }

        return count_hour;
    }

}

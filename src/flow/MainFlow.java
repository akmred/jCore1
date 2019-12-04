package flow;

public class MainFlow {
    public static void main(String[] args) {

        final int size = 10000000;
        final int h = size/2;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        metod1(arr);

        System.out.println("time metod 1: " + (System.currentTimeMillis()-a));

        for (int i = 0; i < arr.length; i++) {

            arr[i] = 1;

        }

        long a1 = System.currentTimeMillis();
        metod2(arr, h);
        System.out.println("time metod 2: " + (System.currentTimeMillis()-a1));


        System.out.println("Выполнение программы закончилось: " + (System.currentTimeMillis()-a1));

    }


    public static void metod1(float arr[]){

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));;

        }

    }

    public static void metod2(float arr[], int h){

        float a1[] = new float[h];
        float a2[] = new float[h];

        // разбивка двух массивов на 2
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> metod1(a1));
        Thread t2 = new Thread(() -> metod1(a2));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // обратная склейка
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

    }



}

package exception;
/*
* Исключение, вызывается при несоответствии длины массива
* */

public class MyArraySizeException  extends  Exception{

    int long_ms;
    int i;
    int j;

    public MyArraySizeException(String message, int long_ms) {
        super(message);
        this.long_ms = long_ms;
    }

    public int getLong_ms() {
        return long_ms;
    }
}

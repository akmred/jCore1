package exception;

/*
* Исключение, вызывается при несоответствии формату элемента массива
* */
public class MyArrayDataException extends Exception{
    String element;
    int i,j;

    public MyArrayDataException(String message, String element, int i, int j) {
        super(message);
        this.element = element;
        this.i = i;
        this.j = j;
    }

    public String getElement() {
        return element;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

}

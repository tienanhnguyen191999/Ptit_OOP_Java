
public class MyException extends Exception{
    private int id;

    public int getId() {
        return id;
    }

    public MyException(int id) {
        this.id = id;
    }
    
}

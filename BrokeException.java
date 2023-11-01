public class BrokeException extends Exception{

    public BrokeException(){
        super("Balance is too low! Can't withdraw.");
    }

}

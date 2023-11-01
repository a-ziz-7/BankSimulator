public class NumberOfAccountsLimit extends Exception{

    public NumberOfAccountsLimit(){
        super("Not allowed to create more than 3 accounts");
    }

}

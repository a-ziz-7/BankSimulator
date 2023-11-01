public class AccountDoesNotExistException extends Exception{

    public AccountDoesNotExistException(String type){
        super("Account of type \"" + type + "\" does not exist.");
    }

}

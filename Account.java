public abstract class Account {//super class for my accounts

    protected Currency currency;

    public Account(Currency deposit) {
        currency = deposit;
    }
    

    public abstract String getType();

    public abstract void withdraw(Currency money) throws Exception;

    public abstract void deposit(Currency money) throws Exception;

    public abstract Currency getBalance();

}

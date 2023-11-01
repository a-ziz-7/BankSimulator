public class Checking extends Account {


    public Checking(Currency val) {
        super(val);
    }

    public String getType(){
        return "Checking";
    }

    public Currency getBalance() {
        return currency;
    }

    public void deposit(Currency amount) {
        currency.add(amount);
    }

    public void withdraw(Currency amount) {
        currency.subtract(amount);
    }

    @Override
    public String toString() {
        return currency.toString();
    }
}

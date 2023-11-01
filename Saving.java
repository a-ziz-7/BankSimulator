public class Saving extends Account {

    double rate;

    public Saving(Currency val, double rate) {
        super(val);
        this.rate = rate;
    }

    public String getType(){
        return "Saving";
    }

    public Currency getBalance() {
        return new Currency((int) (currency.getValue() * (1 + rate)));
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

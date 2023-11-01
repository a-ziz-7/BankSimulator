public class CD extends Account {

    double rate;

    public CD(Currency val, double rate) {
        super(val);
        this.rate = rate;
    }

    public String getType(){
        return "CD";
    }
    public Currency getBalance() {
        return new Currency((int) (currency.getValue() * (1 + rate)));//after 1 period of time
    }

    public void deposit(Currency amount) throws Exception {
        throw new CDAccountException();//illegal call so throws a custom Exception
    }

    public void withdraw(Currency amount) throws Exception {
        throw new CDAccountException();//illegal call so throws a custom Exception
    }

    public String toString() {
        return currency.toString();
    }
}

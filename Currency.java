public class Currency {
    int cents;

    public Currency(int cents) {
        this.cents = cents;
    }

    public int getValue() {
        return cents;
    }

    public void add(Currency rhs) {
        cents += rhs.getValue();
    }

    public void subtract(Currency rhs) {
        cents -= rhs.getValue();
    }

    @Override
    public String toString() {
        return cents / 100 + " dollars " + cents % 100 + " cents";
    }
}

import java.util.ArrayList;
import java.util.Objects;

public class Customer {

    private final String firstName;
    private final String lastName;
    private int accNum;
    private final ArrayList<Account> accList = new ArrayList<>(3);

    public Customer(String fn, String ln) {
        firstName = fn;
        lastName = ln;
    }

    public void addAccount(Account account) throws Exception {
        if(accNum<=3){
            accList.add(account);
            accNum++;
        }else{
            throw new NumberOfAccountsLimit();
        }
    }

    public ArrayList<Account> getAccList(){
        return accList;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void deposit(Currency money, String type)throws Exception{
        for (Account account : accList) {
            if (Objects.equals(account.getType(), type)) {
                account.deposit(money);
                break;
            }
        }
    }

    public void withdraw(Currency money, String type)throws Exception{
        for (Account account : accList) {
            if (Objects.equals(account.getType(), type)) {
                if (account.getBalance().getValue() - money.getValue() < 0) {
                    throw new BrokeException();
                } else {
                    account.withdraw(money);
                    break;
                }
            }
        }
    }
    public Currency balance(String type)throws Exception{
        for (Account account : accList) {
            if (Objects.equals(account.getType(), type)) {
                return account.getBalance();
            } else {
                throw new AccountDoesNotExistException(type);
            }
        }
        return new Currency(0);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return lastName.equals(customer.getLastName()) &&
                firstName.equals(customer.getFirstName());
    }

}

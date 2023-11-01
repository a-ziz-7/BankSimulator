import java.util.Objects;
import java.util.Scanner;

public class Bank {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Customer[] bank = new Customer[10];
        String[] types = {"Checking", "Saving", "CD"};
        int num = 0;
        int action = prompt(sc);// saves what action to perform
        boolean status = true;//status if the user have left
        boolean atm = true;
        while (atm) {//works forever
            if (action == 1 && status) {//new customer
                System.out.println("Enter your first and last name.");
                num = newCustomer(bank, num, sc.next(), sc.next());
                status = false;
                action = prompt(sc);
            } else if (action == 1) {//message that the user has to exit so others can crate an account
                System.out.println("You already have an account.\n" +
                        "Please exit if you are done.");
                action = prompt(sc);
            } else if (action == 2) {//new account
                Account account;
                print();
                int accType = sc.nextInt();
                System.out.println("Enter the balance. (in cents)");
                int money = sc.nextInt();
                if (accType == 1) {
                    account = new Checking(new Currency(money));
                } else if (accType == 2) {
                    account = new Saving(new Currency(money), 0.2);
                } else {
                    account = new CD(new Currency(money), 0.3);
                }
                bank[num - 1].addAccount(account);
                System.out.println("\"" + account.getType() + "\" account created.");
                action = prompt(sc);
            } else if (action == 3) {//balance
                String type;
                print();
                type = types[sc.nextInt()-1];
                getBalance(bank[num - 1], type);
                action = prompt(sc);
            } else if (action == 4) {//deposit
                String type;
                print();
                type = types[sc.nextInt()-1];
                System.out.println("Enter the amount of money you want to deposit (in cents)");
                deposit(bank[num - 1], new Currency(sc.nextInt()), type);
                action = prompt(sc);
            } else if (action == 5) {//withdraw
                String type;
                print();
                type = types[sc.nextInt()-1];
                System.out.println("Enter the amount of money you want to withdraw (in cents)");
                withdraw(bank[num - 1], new Currency(sc.nextInt()), type);
                action = prompt(sc);
            } else if (action == 6) {//next user
                status = true; // will allow the next user to crate an account
                action = prompt(sc);
            } else if (action == 71319) {
                atm = false;
            } else {//if the number is not in 1-6 range
                System.out.println("Please enter a valid action.");
                action = prompt(sc);
            }
        }
    }

    public static int prompt(Scanner sc) {
        System.out.println(
                "\nEnter a number.\n" +
                        "Become a new customer.(1)\n" +
                        "Create an account.(2)\n" +
                        "Account balance(3)\n" +
                        "Deposit money(4)\n" +
                        "Withdraw money(5)\n" +
                        "Exit(6)");
        return sc.nextInt();
    }

    public static int newCustomer(Customer[] arr, int num, String fn, String ln) {
        for (int i = 0; i < num; i++) {
            if (Objects.equals(arr[i].getFirstName(), fn) &&
                    Objects.equals(arr[i].getLastName(), ln)) {
                System.out.println("You already have an account.");
                return num;
            }
        }
        Customer newC = new Customer(fn, ln);
        arr[num] = newC;
        System.out.println(ln + " " + fn + " congrats! You have an account now.");
        return ++num;
    }

    public static void getBalance(Customer customer, String type) throws Exception {

        for (Account account : customer.getAccList()) {
            if (Objects.equals(account.getType(), type)) {
                System.out.println(customer.getFirstName() + " " + customer.getLastName() + "\n" +
                        type + " account has " + customer.balance(type));
                return;
            }
        }
        throw new AccountDoesNotExistException(type);
    }

    public static void deposit(Customer customer, Currency mon, String type) throws Exception {

        for (Account account : customer.getAccList()) {
            if (Objects.equals(account.getType(), type)) {
                System.out.println(customer.getFirstName() + " " + customer.getLastName() +
                        " deposited\n" +
                        mon.getValue() / 100 + " dollars and " + mon.getValue() % 100 + " cents into the \""
                        + type + "\" account");
                customer.deposit(mon, type);
                return;
            }
        }
        throw new AccountDoesNotExistException(type);
    }

    public static void withdraw(Customer customer, Currency mon, String type) throws Exception {

        for (Account account : customer.getAccList()) {
            if (Objects.equals(account.getType(), type)) {
                customer.withdraw(mon, type);
                System.out.println(customer.getFirstName() + " " + customer.getLastName() +
                        " withdrew\n" +
                        mon.getValue() / 100 + " dollars and " + mon.getValue() % 100 + " cents from the \""
                        + type + "\" account");
                return;
            }
        }
    }

    public static void print(){
        System.out.println("Enter an account type.\n" +
                "Checking(1)\n" +
                "Saving(2)\n" +
                "CD(3)");
    }
}
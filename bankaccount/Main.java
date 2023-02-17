
public class Main{
    public static void main(String[] args) {
        BankAccount user = new BankAccount(2,2);
        user.getMoneyTotal();
        user.accountDeposit(20,30);
        user.getMoneyTotal();
        user.withdrawlFromChecking(10);
        user.getMoneyTotal();
        user.withdrawlFromSaving(10);
        user.getMoneyTotal();
    }
}


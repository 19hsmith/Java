public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private static int numberOfBankAccounts = 0;
    private static double moneyStored = 0;
    public BankAccount(double checkingBalance, double savingBalance){
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numberOfBankAccounts++;
        moneyStored += this.getMoneyTotal();
    }

    public static int AccountNumber(){
        return numberOfBankAccounts;
    }

    public double getMoneyTotal(){
        System.out.println(this.checkingBalance + this.savingBalance);
        return this.checkingBalance + this.savingBalance;
    }

    public double getCheckingBalance(double checkingBalance){
        return checkingBalance;
    }

    public double getSavingBalance(double savingBalance){
        return savingBalance;
    }
    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    } 
    public void setSavingBalance(double savingBalance){
        this.savingBalance = savingBalance;
    }
    public void accountDeposit(double deposit, double saving){
        checkingBalance += deposit;
        savingBalance += saving;
    }
    public void checkingAccountDeposit(double checkingAccountDeposit){
        this.checkingBalance += checkingBalance;
    }
    public void savingAccountDeposit(double savingAccountDeposit){
        this.savingBalance += savingBalance;
    }
    public void withdrawlFromChecking(double withdrawl){
        if(this.checkingBalance < withdrawl){
            System.out.println("insufficient funds");
        }
        else{
            this.checkingBalance -= withdrawl;
            moneyStored -= withdrawl;
        }
    }
    public void withdrawlFromSaving(double withdrawl){
        if(this.savingBalance < withdrawl){
            System.out.println("insufficient funds");
        }
        else{
            this.savingBalance -= withdrawl;
            moneyStored -= withdrawl;
        }
    }
}

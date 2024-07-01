package Task3;

public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance ){
        if (initialBalance >= 0 ){
            this.balance = initialBalance;
        }else{
            throw new IllegalArgumentException("Amount Can Not be Negative ");
        }
    }
    public boolean deposit(double amount){
        if(amount > 0 ){
            balance += amount;
            return true;
        }
        return false;
    }
     public boolean withdraw(double amount){
        if(amount >0 && amount <= balance){
            balance -= amount;
            return true;
        }
        return false;

     }
     
     public double getBalance(){
        return balance;
     }
}
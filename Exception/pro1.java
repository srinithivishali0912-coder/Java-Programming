import java.util.*;
class InsufficientBalanceException extends Exception{
    static String err_mes;
    InsufficientBalanceException(String mes){
        err_mes = mes;
    }
    public String toString(){
        return err_mes;
    }
}
class BankAccount{
    public int AccountNumber;
    public String name;
    public int balance;
    BankAccount(int acc_no,String n,int bal){
        AccountNumber = acc_no;
        name = n;
        balance = bal;
    }
    public void withdrawl(int Amount){
        try{
            if(Amount > balance) {
                throw new InsufficientBalanceException("Insufficient Balance Amount: " + balance);
            }
            balance -= Amount;
            System.out.println(name+" !! You withdraw the Amount Successfully.");
            System.out.println("Remaining Balance: "+balance);
        }
        catch(InsufficientBalanceException e){
            System.out.println("Exception: "+e);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int acc_no = sc.nextInt();
        String name = sc.next();
        int balance = sc.nextInt();
        BankAccount b = new BankAccount(acc_no,name,balance);
        int Amount = sc.nextInt();
        try {
            if (Amount <= 0) {
                throw new Exception("Invalid Amount!!");
            }
            b.withdrawl(Amount);
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Hello world!");
    }
}

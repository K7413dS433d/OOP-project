import java.util.Date;

public class Account {

    double balance;
    String date;

    Account(){
        balance=1000;
    }

    Account(double balance){
        this.balance=balance;
    }

    public void setDate(){
        Date d=new Date();
        date=d.toString();
    }

    public String getDate() {
        return date;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        timeDelay(1000);
        return balance;
    }

    public void timeDelay(long t) {   //for delay
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {}
    }



}

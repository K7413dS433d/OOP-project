import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Transactions extends Account{
    double  withdrawal;
    double deposit;
    String code;
    Scanner in=new Scanner(System.in);


    Transactions(){
        withdrawal=0;
        deposit=0;
    }

    public void setWithdrawal(double withdrawal)throws Exception {
        this.withdrawal = withdrawal;
        if(withdrawal<=balance){
        balance-=withdrawal;
        timeDelay(900);
        System.out.printf("%f has been withdrawn \n",withdrawal);
        } else {
            System.out.println("Your balance doesn't allowed withdrawals");
            }
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setDeposit(double deposit)throws Exception {
        this.deposit = deposit;
            balance+=deposit;
            System.out.printf("%f has been deposit \n",deposit);
        }



    public double getDeposit() {
        return deposit;
    }



    int n;
    
    public void moreTrans(){
            do{
            choices();
            try{
            n=in.nextInt();
            }catch(Exception e){
                closing();
                break;
            }
            if(n==1){
                System.out.println("enter the deposit amount");
                try{
                    double d;
                    d=in.nextDouble();
                setDeposit(d);
                transactionCode();
                writeDeposit(d);
                } catch(Exception e){
                    System.out.println("invalid amount");
                    in.nextLine();
                }
            } else if(n==2){
                System.out.println("enter the withdrawal amount");
                try{
                    double w;
                    w=in.nextDouble();
                setWithdrawal(w);
                transactionCode();
                writeWithdrawal(w);
                } catch(Exception e){
                    System.out.println("invalid amount");
                    in.nextLine();
                }
            } else {
                System.out.println("closing transaction...");
                timeDelay(1000);
                break;
            }
        }while(continueTrans()=='y');
    }




    public char continueTrans(){
        char c;
        System.out.println("press y  to continue transactions, press any key to exit");
        c=in.next().charAt(0);
        return c;
    }

    
    public void choices(){
        System.out.println("press 1 to deposit ");
            timeDelay(1000);
            System.out.println("press 2 to withdrawal "); 
            timeDelay(1000);
            System.out.println( "press any key to exit ");
            timeDelay(1000);
    }
    
    public void closing(){
    System.out.println("closing program ...");
    timeDelay(1000);
}



    public void writeDeposit(double f)throws Exception{
        Date d =new Date();
        File file = new File("allData.txt");
        try{
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        print.printf("Transaction code is %s \n",code); 
        print.println("The date of transaction is "+d.toString());
        print.println("The amount of Deposit is "+"+"+f);
        print.println("your current balance is "+balance);
        print.println("***************************************");
        print.close();
        }catch(Exception e){}
    }


    public void writeWithdrawal(double f)throws Exception{
        Date d =new Date();
        File file = new File("allData.txt");
        try{
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        print.printf("Transaction code is %s \n",code);
        print.println("The date of transaction is "+d.toString());
        print.println("The amount of withdrawal is "+"-"+f);
        print.println("your current balance is "+balance);
        print.println("***************************************");
        print.close();
    } catch(Exception e){}
    }


    public void transactionCode(){
        int randomNum = ThreadLocalRandom.current().nextInt(1265494, 9255468);
        String s=Integer.toString(randomNum);
        code=s;
    }

    public void timeDelay(long t) {   //for delay
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {}
    }
    








}

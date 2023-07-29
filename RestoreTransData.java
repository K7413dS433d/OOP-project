import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class RestoreTransData extends Transactions{

    String theChoice;
    int n=1;

Scanner in =new Scanner(System.in);

    public void setTheChoice(String theChoice) {
        this.theChoice = theChoice;
    }

    public String getTheChoice() {
        return theChoice;
    }


    public void choices(){
        System.out.println("press  1 to show details or press any key to close");
        if(in.nextLine().equals("1")){
            System.out.println("Select the code of transaction to show details ");
            timeDelay(1000);
            System.out.println("write the code ");
            setTheChoice(in.nextLine());
            try{
            returnData(getTheChoice());
            }catch(Exception e){}
        }
    }


    public void returnData(String c)throws Exception{
        File file =new File("allData.txt");
        File outputData = new File("outputData.txt");
        String find=(String)("Transaction code is "+c);
        String st ;
        try{
        BufferedReader reader=new BufferedReader(new FileReader(file));
        try{
        PrintWriter print = new PrintWriter(outputData);
        
        while((st=reader.readLine())!=null){
            if(n==5) break;
                if(st.contains(find)){
                    print.println(st);
                    while((st=reader.readLine())!=null){
                        if(n==5) break;
                        print.println(st);
                        n++;
                    }
                }
                
        }
        print.close();
        }catch(Exception e){}
        reader.close();
    }catch(Exception e){}
        System.out.println("Check the output file");
        System.out.println("Your current balance is "+getBalance());
        System.out.println("closing .....");
timeDelay(1000);
    }




    public void timeDelay(long t) {   //for delay
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {}
    }
}

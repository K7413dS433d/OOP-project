public class Main {
    public static void main(String[] args) {
        User u=new User();
        Transactions t=new Transactions();
        RestoreTransData r=new RestoreTransData();
        System.out.println("Enter the name and password ");
        if(u.validUser()){
            System.out.printf("your balance is %f \n",t.getBalance());
            t.moreTrans();
        }
        r.choices();
            
    }
}

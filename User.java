import java.util.Scanner;

public class User {
    String name;
    String pass;
    String currentName = "khaled";
    String currentPass;
    String nationalID = "987654321";
    boolean checkSignIn = false;
    int signInNum;

    Scanner in = new Scanner(System.in);

    User() {
        name = null;
        currentPass = "1234";
        signInNum = 1;
    }


    User(String nationalID ,String currentPass,String currentName){
        this.nationalID= nationalID;
        this.currentPass=currentPass;
        this.currentName=currentName;
    }


    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public void setCurrentPass(String currentPass) {
        this.currentPass = currentPass;
    }

    public String getCurrentName() {
        return currentName;
    }

    public String getCurrentPass() {
        return currentPass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPass(String p) {
        this.pass =new String(p);
        currentPass = new String (p);
    }

    public String getPass() {
        return pass;
    }

    public boolean check(String n1, String n2) {
        if (n1.equals(getCurrentName()) && n2.equals(getCurrentPass())) {
            Files f = new Files();
            checkSignIn = true;
            System.out.println("User Accepted");
            f.ExcTheSignIn();
            return true;
        }
        System.out.println("the name or password is invalid");
        timeDelay(1000);
        return false;
    }

    public boolean validUser() {
        while (!check(in.nextLine(), in.nextLine())) {
            if (signInNum == 3) {
                System.out.println("You set the password three times wrong");
                timeDelay(1000);
                System.out.printf("press 1 to to reset the password  press any key close the program \n");
                if (in.nextLine().equals("1")) {
                    if (checkNationalID()) {
                        changePass();
                        signInNum = 1;
                    }
                } else {
                    System.out.println("closing the program...");
                    timeDelay(2000);
                    return false;
                }
            }
            signInNum++;
            System.out.println("Enter the name and password again");
            timeDelay(1000);
        }
        return true;
    }

    public void changePass() {
        System.out.println("please set the new password");
        setPass(in.nextLine());
        while (getPass().length() < 4) {
            System.out.println("number of characters should be more than 4" + "\n" + "insert another password");
            setPass(in.nextLine());
        }
    }

    public boolean checkNationalID() {
        int countIDInput = 1;
        System.out.println("Enter your national id to reset the password");
        timeDelay(500);
        while (!nationalID.equals(in.nextLine())) {
            if (countIDInput == 3) {
                return false;
            }
            countIDInput++;
            System.out.println("error invalid national ID" + "\n" + "input your national id again");
        }
        return true;
    }

    public boolean getCheckSignIn() {
        return checkSignIn;
    }

    public void timeDelay(long t) { // for delay
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
        }
    }

}

import java.io.File;
import java.util.Date;
import java.io.*;

public class Files extends User {

    public void theSignIn() throws Exception {
        File file = new File("signInInfo.txt");
        PrintWriter print = new PrintWriter(file);
        print(print);
    }

    public void ExcTheSignIn() {
        try {
            theSignIn();
        } catch (Exception e) {
        }
    }

    public void print(PrintWriter print) {
        Date d = new Date();
        print.printf("Signed at %s \n", d.toString());
        print.println("The user name is " + getCurrentName());
        print.println("The password is "+getCurrentPass());
        print.close();
    }

}

import java.io.IOException;
import java.util.Scanner;

public class OneS2Watch {

    private static WatchMode watchMode = ClockMode.getInstance();


    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter one of the Buttons 'A,B,C', 0 To Exit ");
            Scanner input = new Scanner(System.in);
            char a = input.next().charAt(0);
            if (a == 'A') {
                OneS2Watch.watchMode = OneS2Watch.watchMode.buttonA();
            } else if (a == 'B')
                OneS2Watch.watchMode.buttonB();

            else if (a == 'C')
                OneS2Watch.watchMode.buttonC();
        }

    }

}

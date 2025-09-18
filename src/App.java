import java.util.Scanner;

public class App {
    /*
     * Här skriver jag 3 variablr en
     * variabl till PinKod ,till saldo och till försök.
     */
    static int pin = 1234;
    static int saldo = 0;
    static int försök = 0;

    public static void main(String[] args) throws Exception {
         Scanner input = new Scanner(System.in);

        if (loggaIn(input)) {
           
        } else {
            System.out.println("Boss!!! du glömet din pin?! Snälla försök senare. Programmet avslutas.");
        }

        input.close();

    }

    private static boolean loggaIn(Scanner input) {
        while (försök < 3) {
            System.out.print("Ange din pinkod: ");
            int dinPinKod = input.nextInt();
            input.nextLine();

            if (dinPinKod == pin) {
                System.out.println("Välkommen Boss!");
                return true;
            } else {
                System.out.println("Fel pin, försök igen!");
                försök++;
            }
        }
        return false;
    }
}

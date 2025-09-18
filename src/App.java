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
            Meny(input);
           
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
    // Metod 2: den här metoden är för meny och saldo
    private static void Meny(Scanner input) {
        boolean konto = true;
        while (konto) {
            System.out.println("Välj ett alternativ:\n" + "****" + " " + "MENY " + "  " + "****\n" + "1. Se saldo\n"
                   );

            String val = input.nextLine();

            switch (val) {
                case "1":
                    System.out.println("Du saldo: " + saldo + " kr.");
                    break;
               

                default:
                    System.out.println("Du kan välja bara mellan 1, 2, 3 eller 4.");
                    break;
            }
        }
    }
}

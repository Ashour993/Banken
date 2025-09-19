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
            int dinPinKod = läsHeltal(input);
            

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
    private static int läsHeltal(Scanner input) {
    while (true) {
        String inmatning = input.nextLine();
        try {
            return Integer.parseInt(inmatning);
        } catch (NumberFormatException e) {
            System.out.print("Ange ett heltal: ");
        }
    }

            // Metod 1: Den här metod användaren kan bytas sin pinKod!
}       private static void ändraLösenOrd (Scanner input){
            System.out.println("Ange din gammla lösenord: ");
            int gammalPin = läsHeltal(input);
            if (gammalPin == pin ) {
                System.out.println("ange din nya pinKod: ");
                int nyPinKod = läsHeltal(input);
                pin = nyPinKod;
                System.out.println("Din gammal pinKod är ändrad!");
                
            } else {
                System.out.println("Fel pinKod!! Du kan inte ändra!!");
            }
}


    
    // Metod 2: den här metoden är för meny och saldo
     private static void Meny(Scanner input) {
        boolean konto = true;
        while (konto) {
            System.out.println("Välj ett alternativ:\n" + "****" + " " + "MENY " + "  " + "****\n" + "1. Se saldo\n" + "2. Insättning\n" + "3. Uttag\n" + "4. Ändra din LösenOrd!\n" + "5. Avsluta programmet!"
                   );

            String val = input.nextLine();

            switch (val) {
                case "1":
                    System.out.println("Du saldo: " + saldo + " kr.");
                    break;
                    case "2":
                    System.out.print("Ange din cash Boss: ");
                    int insätt = läsHeltal(input);
                    
                   
                    saldo += insätt;
                    System.out.println("Du satte in " + insätt + " kr. Din saldo blir: " + saldo
                            + " kr.  Boss du blir lite rikare idag :)");
                    break;
                    case "3":
                    System.out.print("Boss hur mycket cash ta ut vi idag : ");
                    int uttag = läsHeltal(input);
                    
                    if (uttag > saldo) {
                        System.out.println("Tyvär Boss du har bara: " + saldo + " kr. Lägg lite extra cash ;)");
                    } else {
                        System.out.println("Du tog ut " + uttag + " kr. Din nya  saldo: " + saldo + " kr.");
                        saldo -= uttag;
                    }
                    break;
                    case "4":
                    ändraLösenOrd(input);
                    break;

                    case "5":
                    System.out.println("Programmet avslutas.");
                    konto = false;
                    break;

               

                default:
                    System.out.println("Du kan välja bara mellan 1, 2, 3, 4 eller 5.");
                    break;
                    
            }
        }
    }
    
}

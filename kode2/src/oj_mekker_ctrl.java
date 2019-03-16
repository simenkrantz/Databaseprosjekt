import java.util.Scanner;

public class oj_mekker_ctrl extends DBConn {
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn navn: ");
        String navn = scanner.nextLine();

        System.out.println("Skriv inn telefonnummer: ");
        int telefonnummer = Integer.parseInt(scanner.nextLine());

        System.out.println("Navn ble: " + navn);
        System.out.println("telefonnummer ble: " + telefonnummer);

        //DBOperations.addPerson(conn, navn, telefonnummer);
     }


     public void addOvelsesgruppe() {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Skriv inn gruppenavn: ");
         String navn = scanner.nextLine();

         System.out.println("Gruppenavn ble: " + navn);

         //DBOperations.addOvelsesgruppe(conn, navn);
      }

}

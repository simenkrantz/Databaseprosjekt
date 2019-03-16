import java.util.Scanner;

public class TreningsCtrl extends DBConn {
    public void addPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn navn: ");
        String navn = scanner.nextLine();

        System.out.println("Skriv inn telefonnummer: ");
        int telefonnummer = scanner.nextLine();

        System.out.println("Navn ble: " + navn);
        System.out.println("telefonnummer ble: " + telefonnummer);

        Person test_person = new Person(navn, telefonNummer);

        DBOperations.addPerson(conn, test_person);
     }


     public void addOvelsesgruppe() {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Skriv inn gruppenavn: ");
         String navn = scanner.nextLine();

         System.out.println("Gruppenavn ble: " + navn);

         Ovelsesgruppe test_gruppe = new Ovelsesgruppe(navn);

         DBOperations.addOvelsesgruppe(conn, test_gruppe);
      }

}

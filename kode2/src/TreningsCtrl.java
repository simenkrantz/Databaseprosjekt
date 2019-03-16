import java.sql.SQLException;
import java.util.Scanner;

public class TreningsCtrl extends DBConn {
    public void addApparat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn navn på apparat: ");
        String navn = scanner.nextLine();

        System.out.println("Skriv inn beskrivelse på apparat: ");
        String beskrivelse = scanner.nextLine();
        
        Apparat a1 = new Apparat(navn, beskrivelse);

        DBOperations.addApparat(conn, a1.getApparatID(), a1.getNavn(), a1.getBeskrivelse());
     }

     public void addOvelse() throws SQLException {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Skriv inn navn på øvelse: ");
         String navn = scanner.nextLine();

         System.out.println("Skriv inn form (int): ");
         int form = Integer.parseInt(scanner.nextLine());

         System.out.println("Skriv inn prestasjon (int): ");
         int prestasjon = Integer.parseInt(scanner.nextLine());

         System.out.println("Fastmontert(1) eller Frittstående(2): ");
         int type = Integer.parseInt(scanner.nextLine());
         if (type == 1){
             System.out.println("Apparater å velge mellom:");
             DBOperations.printApparater(conn);
             System.out.println("Skriv inn apparatID: ");
             int apparatID = Integer.parseInt(scanner.nextLine());

             System.out.println("Skriv inn antall kg: ");
             int antallKg = Integer.parseInt(scanner.nextLine());
             System.out.println("Skriv inn antall sett: ");
             int antallSett = Integer.parseInt(scanner.nextLine());


             Ovelse o = new Ovelse(navn);
             DBOperations.addFastmontert(conn, navn, form, prestasjon, o.getOvelseID(), antallKg, antallSett, apparatID );
         } else {

         }


     }
}
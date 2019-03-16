import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TreningsCtrl extends DBConn {
    public void addApparat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn navn på apparat: ");
        String navn = scanner.nextLine();

        System.out.println("Skriv inn beskrivelse på apparat: ");
        String beskrivelse = scanner.nextLine();

        DBOperations.addApparat(conn, navn, beskrivelse);
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
            System.out.println("Skriv inn antall kg: ");
            int antallKg = Integer.parseInt(scanner.nextLine());
            System.out.println("Skriv inn antall sett: ");
            int antallSett = Integer.parseInt(scanner.nextLine());

            System.out.println("Apparater å velge mellom:");
            DBOperations.printApparater(conn);
            System.out.println("Skriv inn apparatID: ");
            int apparatID = Integer.parseInt(scanner.nextLine());

            boolean apparatOK = false;
            for (Apparat a : DBOperations.getApparater(conn)){
                if (apparatID == a.getApparatID()){
                    apparatOK = true;
                    DBOperations.addFastmontert(conn, navn, form, prestasjon, antallKg, antallSett, a);
                    break;
                }
            }
            if(!apparatOK){
                System.out.println("Apparatet finnes ikke");
            }
        } else {
            System.out.println("Skriv inn beskrivelse på øvelse: ");
            String beskrivelse = scanner.nextLine();

            DBOperations.addFrittstaende(conn, navn, form, prestasjon,beskrivelse);
        }


     }
}
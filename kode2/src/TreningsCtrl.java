import java.util.Scanner;

public class TreningsCtrl extends DBConn {
    public void addApparat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn navn på apparat: ");
        String navn = scanner.nextLine();

        System.out.println("Skriv inn beskrivelse på apparat: ");
        String beskrivelse = scanner.nextLine();

        System.out.println("Apparatnavn ble: " + navn);
        System.out.println("Beskrivelse ble: " + beskrivelse);
        
        Apparat benk = new Apparat(navn, beskrivelse);
        
        DBOperations.addApparat(conn, benk);
    
 
     }
}
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, treningsdagbok");
        System.out.println("Kobler til Database...");
        TreningsCtrl treningsCtrl = new TreningsCtrl ();
        treningsCtrl.connect();
        System.out.println("Tilkobling vellykket!");

        printMenu();
        int valg = Integer.parseInt(scanner.nextLine());

        while (valg != 0) {
            switch (valg) {
                case 0:
                    break;
                case 1:
                    treningsCtrl.addApparat();
                    break;
                case 2:
                    treningsCtrl.addOvelse();
                    break;
                case 3:
                    treningsCtrl.addPerson();
                    break;
                case 4:
                    treningsCtrl.addTreningsokt();
                    break;
                case 5:
                    treningsCtrl.addOvelseToTreningsokt();
                    break;
                case 6:
                    treningsCtrl.printApparater();
                    break;
                case 7:
                    treningsCtrl.printOvelser();
                    break;
                case 8:
                    treningsCtrl.printPersoner();
                    break;
                case 9:
                    treningsCtrl.printTreningsokter();
                    break;
                case 10:
                    treningsCtrl.printOvelserITreningsokt();
                    break;
                case 11:
                    treningsCtrl.printLoggForOvelseITidsrom();
                    break;
                case 12:
                    treningsCtrl.printNSisteTreningsokter();
                    break;
                case 13:
                    treningsCtrl.printOvelsesgrupper();
                    break;
                case 14:
                    treningsCtrl.addOvelsesgruppe();
                    break;
                case 15:
                    treningsCtrl.printOvelserIOvelsesgruppe();
                    break;
                default:
                    System.out.println("Ikke et valg, velg igjen");
            }
            printMenu();
            valg = Integer.parseInt(scanner.nextLine());
        }
    }

    public static void printMenu(){
        System.out.println("\nMENY: ");
        System.out.println("0: AVSLUTT");
        System.out.println("1: Legg til Apparat");
        System.out.println("2: Legg til Øvelse");
        System.out.println("3: Legg til Person");
        System.out.println("4: Legg til Treningsøkt");
        System.out.println("5: Legg til Øvelse i Treningsøkt");

        System.out.println("6: Skriv ut Apparater");
        System.out.println("7: Skriv ut Øvelser");
        System.out.println("8: Skriv ut Personer");
        System.out.println("9: Skriv ut Treningsøkter");
        System.out.println("10: Skriv ut hvilke Øvelser som er i Treningsøkt");
        System.out.println("11: Skriv ut logg for en øvelse");
        System.out.println("12: Skriv ut logg for n siste treningsøkter");
        System.out.println("13: Skriv ut Øvelsesgrupper");
        System.out.println("14: Legg til Øvelsesgruppe");
        System.out.println("15: Skriv ut Øvelser i Øvelsesgruppe");
        System.out.printf("\nSkriv inn et valg: ");
    }

}

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
                    DBOperations.addFastmontert(conn, navn, antallKg, antallSett, a);
                    break;
                }
            }
            if(!apparatOK){
                System.out.println("Apparatet finnes ikke");
            }
        } else {
            System.out.println("Skriv inn beskrivelse på øvelse: ");
            String beskrivelse = scanner.nextLine();

            DBOperations.addFrittstaende(conn, navn,beskrivelse);
        }


    }

    public void addTreningsokt () throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn dato på økt (YYYY-MM-DD): ");
        java.sql.Date dato = java.sql.Date.valueOf(scanner.nextLine());

        System.out.println("Skriv inn tidspunkt på økt (HH:MM:SS): ");
        java.sql.Time tidspunkt = java.sql.Time.valueOf(scanner.nextLine());

        System.out.println("Skriv inn varigheten på økt (int minutter): ");
        int varighet = Integer.parseInt(scanner.nextLine());

        System.out.println("Skriv inn form (int): ");
        int form = Integer.parseInt(scanner.nextLine());

        System.out.println("Skriv inn prestasjon (int): ");
        int prestasjon = Integer.parseInt(scanner.nextLine());


        DBOperations.printPersoner(conn);

        System.out.println("Skriv inn id på treningspartner (-1 hvis ingen): ");
        int personID = Integer.parseInt(scanner.nextLine());

        System.out.println("Skriv inn notat til økten (1 linje): ");
        String notat = scanner.nextLine();

        if (personID != -1) {
            boolean personOK = false;
            for (Person p : DBOperations.getPersoner(conn)) {
                if (personID == p.getPersonID()) {
                    personOK = true;
                    DBOperations.addTreningsokt(conn, dato, tidspunkt, varighet,form,prestasjon, p, notat);
                    break;
                }
            }
            if (!personOK) {
                System.out.println("Personen finnes ikke");
            }
        } else {
            DBOperations.addTreningsokt(conn,dato,tidspunkt,varighet,form,prestasjon,notat);
        }
    }

    public void addPerson() throws SQLException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv inn navn: ");
        String navn = scanner.nextLine();

        System.out.println("Skriv inn telefonnummer: ");
        int telefonnummer = Integer.parseInt(scanner.nextLine());

        DBOperations.printOvelser(conn);

        System.out.println("Skriv inn id på favorittøvelse (-1 hvis ingen): ");
        int ovelseID = Integer.parseInt(scanner.nextLine());

        if (ovelseID != -1) {
            boolean ovelseOK = false;
            for (Ovelse o : DBOperations.getOvelser(conn)) {
                if (ovelseID == o.getOvelseID()) {
                    ovelseOK = true;
                    DBOperations.addPerson(conn, navn, telefonnummer, o);
                    break;
                }
            }
            if (!ovelseOK) {
                System.out.println("Ovelsen finnes ikke");
            }
        } else {
            DBOperations.addPerson(conn, navn, telefonnummer);
        }
    }

    public void addOvelseToTreningsokt() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DBOperations.printTreningsokter(conn);
        System.out.println("Skriv inn id på økten du vil legge til øvelse i: ");
        int oktID = Integer.parseInt(scanner.nextLine());

        DBOperations.printOvelser(conn);

        System.out.println("Skriv inn id på øvelsen du vil legge til i økten: ");
        int ovelseID = Integer.parseInt(scanner.nextLine());

        boolean OK = false;
        for (Treningsokt t : DBOperations.getTreningsOkter(conn)) {
            if (oktID == t.getOktID()) {
                for (Ovelse o : DBOperations.getOvelser(conn)) {
                    if (ovelseID == o.getOvelseID()) {
                        OK = true;
                        DBOperations.addOvelseToTreningsokt(conn, t, o);
                        break;
                    }
                }
                break;
            }

        }

        if (!OK) {
            System.out.println("Ovelsen eller økten finnes ikke");
        }
    }


    public void printApparater() throws SQLException {
        DBOperations.printApparater(conn);
    }

    public void printOvelser() throws SQLException {
        DBOperations.printOvelser(conn);
    }

    public void printPersoner() throws SQLException {
        DBOperations.printPersoner(conn);
    }

    public void printTreningsokter() throws SQLException {
        DBOperations.printTreningsokter(conn);
    }

    public void printOvelserITreningsokt() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        printTreningsokter();

        System.out.println("Skriv inn id på Treningsøkten du vil se øvelsene til: ");
        int oktID = Integer.parseInt(scanner.nextLine());

        for (Treningsokt t : DBOperations.getTreningsOkter(conn)){
            if (oktID == t.getOktID()){
                List<Ovelse> ovelseList = DBOperations.getOvelserITreningsokt(conn,t);
                for (Ovelse o : ovelseList) {
                    System.out.println("ID: " + o.getOvelseID() + " navn: " + o.getNavn());
                }
                break;
            }
        }
    }

    public void printTreningsokterOvelseErI() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        printOvelser();

        System.out.println("Skriv inn id på Øvelsen du vil se logg for: ");
        int ovelseID = Integer.parseInt(scanner.nextLine());

        for (Ovelse o : DBOperations.getOvelser(conn)){
            if (ovelseID == o.getOvelseID()){
                List<Treningsokt> oktList = DBOperations.getTreningsokterOvelseErI(conn,o);
                for (Treningsokt t : oktList) {
                    System.out.println("ID: " + t.getOktID() + " dato: " + t.getDato() +
                            " tidspunkt: " + t.getTidspunkt() + " treningspartner: " + t.getPartner().getNavn());
                }
                break;
            }
        }
    }

    public void printNSisteTreningsokter() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv inn antall [int,1-index] siste treningsøkter: ");
        int num = Integer.parseInt(sc.nextLine());

        for (Treningsokt t : DBOperations.getNSisteTreningsokter(conn, num)){
            if (t.getPartner() != null){
                System.out.println("ID: " + t.getOktID() + ", dato: " + t.getDato()+ ", tidspunkt: " + t.getTidspunkt() +
                        ", varighet: " + t.getVarighet() + ", form: " + t.getForm()+ ", prestasjon: " + t.getPrestasjon() +
                        " treningspartner: " + t.getPartner().getNavn()+ ", notat: " + t.getNotat());
            }
            else{
                System.out.println("ID: " + t.getOktID() + ", dato: " + t.getDato()+ ", tidspunkt: " + t.getTidspunkt() +
                        ", varighet: " + t.getVarighet() + ", form: " + t.getForm()+ ", prestasjon: " + t.getPrestasjon() +
                        ", notat: " + t.getNotat());
            }
        }
    }
}
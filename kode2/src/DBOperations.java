import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBOperations {

    public static void addApparat(Connection conn, String navn, String beskrivelse) {

        String query = "INSERT INTO Apparat (navn, beskrivelse) VALUES (?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setString(1, navn);
            prepStat.setString(2, beskrivelse);

            prepStat.execute();

            System.out.println("Apparat lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Apparat", e);
            //System.out.println("DB error when inserting Apparat");
        }
    }

    public static void addOvelsesgruppe(Connection conn, String navn) {
        String query = "INSERT INTO Ovelsesgruppe (navn) VALUES (?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setString(1, navn);

            prepStat.execute();

            System.out.println("Ovelsesgruppe lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting ovelsesgruppe", e);
        }
    }

    public static void addPerson(Connection conn, String navn, int telefonnummer, Ovelse favorittOvelse) {

        String query = "INSERT INTO Person (navn, tlfnr, favorittovelse) VALUES (?,?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setString(1, navn);
            prepStat.setInt(2, telefonnummer);
            prepStat.setInt(3, favorittOvelse.getOvelseID());

            prepStat.execute();

            System.out.println("Person lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Person", e);
        }
    }

    public static void addPerson(Connection conn, String navn, int telefonnummer) {

        String query = "INSERT INTO Person (navn, tlfnr) VALUES (?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setString(1, navn);
            prepStat.setInt(2, telefonnummer);

            prepStat.execute();

            System.out.println("Person lagt til uten favorittøvelse");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Person", e);
        }
    }

    public static void addFastmontert(Connection conn, String navn, Ovelsesgruppe gruppe, int antallKg, int antallSett, Apparat apparat) {

        String queryOvelse = "INSERT INTO Ovelse (navn, gruppeID) VALUES (?,?)";
        String queryFastmontert = "INSERT INTO Fastmontert (ovelseID, antall_kg, antall_sett, apparat) VALUES (?,?,?,?)";
        

        try {
            PreparedStatement prepStatOvelse = conn.prepareStatement(queryOvelse);

            prepStatOvelse.setString(1, navn);
            prepStatOvelse.setInt(2,gruppe.getGruppeID());

            prepStatOvelse.execute();
        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Ovelse", e);
        }

        try{
            PreparedStatement prepStatFast = conn.prepareStatement(queryFastmontert);
            System.out.println("largest id: " + (getHoyesteOvelseID(conn)));

            prepStatFast.setInt(1, getHoyesteOvelseID(conn));
            prepStatFast.setInt(2, antallKg);
            prepStatFast.setInt(3, antallSett);
            prepStatFast.setInt(4, apparat.getApparatID());

            prepStatFast.execute();

            System.out.println("Fastmontert ovelse lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Fastmontert", e);
        }
    }

    public static void addFrittstaende(Connection conn, String navn, Ovelsesgruppe gruppe, String beskrivelse) {

        String queryOvelse = "INSERT INTO Ovelse (navn, gruppeID) VALUES (?,?)";
        String queryFritt = "INSERT INTO Frittstaende (ovelseID, beskrivelse) VALUES (?,?)";


        try {
            PreparedStatement prepStatOvelse = conn.prepareStatement(queryOvelse);

            prepStatOvelse.setString(1, navn);
            prepStatOvelse.setInt(2,gruppe.getGruppeID());

            prepStatOvelse.execute();
        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Ovelse", e);
        }
        try {
            PreparedStatement prepStatFritt = conn.prepareStatement(queryFritt);

            prepStatFritt.setInt(1, getHoyesteOvelseID(conn));
            prepStatFritt.setString(2, beskrivelse);

            prepStatFritt.execute();

            System.out.println("Frittstående ovelse lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Frittstående", e);
        }
    }

    public static void addTreningsokt(Connection conn, java.sql.Date dato, java.sql.Time tidspunkt, int varighet, int form, int prestasjon, Person partner, String notat) {

        String query = "INSERT INTO Treningsokt(dato, tidspunkt,varighet,form,prestasjon,treningspartner,notat) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setDate(1, dato);
            prepStat.setTime(2, tidspunkt);
            prepStat.setInt(3, varighet);
            prepStat.setInt(4, form);
            prepStat.setInt(5,prestasjon);
            prepStat.setInt(6, partner.getPersonID());
            prepStat.setString(7, notat);

            prepStat.execute();

            System.out.println("Økt lagt til.");

        }
        catch (Exception e) {
            throw new RuntimeException("Error ved inserting av økt", e);
        }
    }

    public static void addTreningsokt(Connection conn, java.sql.Date dato, java.sql.Time tidspunkt, int varighet,int form, int prestasjon, String notat) {

        String query = "INSERT INTO Treningsokt(dato, tidspunkt,varighet,form,prestasjon, notat) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setDate(1, dato);
            prepStat.setTime(2, tidspunkt);
            prepStat.setInt(3, varighet);
            prepStat.setInt(4, form);
            prepStat.setInt(5,prestasjon);
            prepStat.setString(6, notat);

            prepStat.execute();

            System.out.println("Økt lagt til uten treningspartner.");

        }
        catch (Exception e) {
            throw new RuntimeException("Error ved inserting av økt", e);
        }
    }

    public static void addOvelseToTreningsokt(Connection conn, Treningsokt okt, Ovelse ovelse) {
        String query = "INSERT INTO Ovelseriokt(oktID, ovelseID) VALUES (?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setInt(1, okt.getOktID());
            prepStat.setInt(2, ovelse.getOvelseID());

            prepStat.execute();

            System.out.println("Øvelse " + ovelse.getNavn() + " lagt til i økt " + okt.getOktID());

        }
        catch (Exception e) {
            throw new RuntimeException("Error ved inserting av øvelse i økt", e);
        }
    }


    public static List<Apparat> getApparater(Connection conn) throws SQLException{
        List<Apparat> apparater = new ArrayList<>();

        String queryStatement = "SELECT * FROM Apparat";
        PreparedStatement prepStat = conn.prepareStatement(queryStatement);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()){
            Apparat apparat = new Apparat(rs.getInt("apparatID"),rs.getString("navn"), rs.getString("beskrivelse"));
            apparater.add(apparat);
        }
        return apparater;
    }

    public static List<Ovelse> getOvelser(Connection conn) throws SQLException {
        List<Ovelse> ovelser = new ArrayList<Ovelse>();
        
        String stmt = "SELECT * FROM Frittstaende NATURAL JOIN Ovelse";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
            for (Ovelsesgruppe g : getOvelsesgrupper(conn)) {
                if (rs.getInt("gruppeID") == g.getGruppeID()) {
                    Ovelse o = new Frittstaende(rs.getInt("ovelseID"), rs.getString("navn"), g, rs.getString("beskrivelse"));
                    ovelser.add(o);
                }
            }
        }

        String stmt2 = "SELECT * FROM Fastmontert NATURAL JOIN Ovelse";
        PreparedStatement prepStat2 = conn.prepareStatement(stmt2);
        ResultSet rs2 = prepStat2.executeQuery();

        while(rs2.next()) {
            for(Apparat a : getApparater(conn)){
                if (a.getApparatID() == rs2.getInt("apparat")){
                    for (Ovelsesgruppe g : getOvelsesgrupper(conn)) {
                        if (rs2.getInt("gruppeID") == g.getGruppeID()) {
                            Ovelse o = new Fastmontert(rs2.getInt("ovelseID"), rs2.getString("navn"),g,
                                    rs2.getInt("antall_kg"), rs2.getInt("antall_sett"), a);
                            ovelser.add(o);
                        }
                    }
                }
            } 
        }
        return ovelser;
    }

    public static int getHoyesteOvelseID(Connection conn) throws SQLException {
        List<Ovelse> ovelser = new ArrayList<Ovelse>();

        String stmt = "select * from Ovelse";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
            for (Ovelsesgruppe g : getOvelsesgrupper(conn)) {
                if (rs.getInt("gruppeID") == g.getGruppeID()) {
                    Ovelse o = new Ovelse(rs.getInt("ovelseID"), rs.getString("navn"),g);
                    ovelser.add(o);
                }
            }
        }

        int storst = 1;
        for (Ovelse o : ovelser){
            if (o.getOvelseID() > storst){
                storst = o.getOvelseID();
            }
        }
        return storst;
    }

    public static List<Person> getPersoner(Connection conn) throws SQLException {
        List<Person> personer = new ArrayList<Person>();
        
        String stmt = "select * from Person";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
            if (rs.getObject("favorittovelse") != null){
                for (Ovelse o : getOvelser(conn)){
                    if(o.getOvelseID() == rs.getInt("favorittovelse")){
                        Person p = new Person(rs.getInt("personID"), rs.getString("navn"), rs.getInt("tlfnr"), o);
                        personer.add(p);
                    }
                }
            } else {
                Person p = new Person(rs.getInt("personID"), rs.getString("navn"), rs.getInt("tlfnr"));
                personer.add(p);
            }
        }
        return personer;
    }

    public static List<Treningsokt> getTreningsOkter(Connection conn) throws SQLException{
    		
        List<Treningsokt> treningsOkter = new ArrayList<Treningsokt>();
        
        String stmt = "select * from Treningsokt";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();
        
        while(rs.next()) {
            if (rs.getObject("treningspartner") != null){
                for (Person p : getPersoner(conn)){
                    if (rs.getInt("treningspartner") == p.getPersonID()){
                        Treningsokt t = new Treningsokt(rs.getInt("oktID") , rs.getDate("dato"), rs.getTime("tidspunkt"),
                                                        rs.getInt("varighet"), rs.getInt("form"), rs.getInt("prestasjon"), rs.getString("notat"), p);
                        treningsOkter.add(t);
                    }
                }
            } else {
                Treningsokt t = new Treningsokt(rs.getInt("oktID") , rs.getDate("dato"), rs.getTime("tidspunkt"),
                rs.getInt("varighet"), rs.getInt("form"), rs.getInt("prestasjon"), rs.getString("notat"));
                treningsOkter.add(t);
            }
        }
        
        return treningsOkter;
}

    public static List<Ovelsesgruppe> getOvelsesgrupper(Connection conn) throws SQLException {
        List<Ovelsesgruppe> grupper = new ArrayList<Ovelsesgruppe>();

        String stmt = "select * from Ovelsesgruppe";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
                Ovelsesgruppe g = new Ovelsesgruppe(rs.getInt("gruppeID"), rs.getString("navn"));
                grupper.add(g);
            }
        return grupper;
    }

    public static List<Ovelse> getOvelserITreningsokt(Connection conn, Treningsokt okt) throws SQLException {
        List<Ovelse> ovelseriokt = new ArrayList<Ovelse>();

        String stmt = "select * from Ovelseriokt";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
            if (rs.getInt("oktID") == okt.getOktID()) {
                for (Ovelse o : getOvelser(conn)) {
                    if (rs.getInt("ovelseID") == o.getOvelseID()){
                        ovelseriokt.add(o);
                    }
                }
            }
        }

        return ovelseriokt;
    }

    public static List<Treningsokt> getTreningsokterOvelseErI(Connection conn, Ovelse ovelse) throws  SQLException {
        List<Treningsokt> okter = new ArrayList<Treningsokt>();

        String stmt = "select * from Ovelseriokt";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
            if (rs.getInt("ovelseID") == ovelse.getOvelseID()) {
                for (Treningsokt t : getTreningsOkter(conn)) {
                    if (rs.getInt("oktID") == t.getOktID()){
                        okter.add(t);
                    }
                }
            }
        }

        return okter;
    }

    public static List<Treningsokt> getNSisteTreningsokter(Connection conn, int num) throws SQLException{
        List<Treningsokt> treningsOkter = new ArrayList<Treningsokt>();

        String stmt = "select * from Treningsokt ORDER BY dato DESC";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        int n = 0;
        while(rs.next() && n < num) {
            if (rs.getObject("treningspartner") != null){
                for (Person p : getPersoner(conn)){
                    if (rs.getInt("treningspartner") == p.getPersonID()){
                        Treningsokt t = new Treningsokt(rs.getInt("oktID") , rs.getDate("dato"), rs.getTime("tidspunkt"),
                                rs.getInt("varighet"), rs.getInt("form"), rs.getInt("prestasjon"), rs.getString("notat"), p);
                        treningsOkter.add(t);
                    }
                }
            } else {
                Treningsokt t = new Treningsokt(rs.getInt("oktID") , rs.getDate("dato"), rs.getTime("tidspunkt"),
                        rs.getInt("varighet"), rs.getInt("form"), rs.getInt("prestasjon"), rs.getString("notat"));
                treningsOkter.add(t);
            }
            n += 1;
        }

        return treningsOkter;
    }

    public static void printApparater(Connection conn) throws SQLException{
        String queryStatement = "SELECT * FROM Apparat";
        PreparedStatement prepStat = conn.prepareStatement(queryStatement);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()){
            System.out.println("ID: " + rs.getInt("apparatID") + ", navn: " + rs.getString("navn"));
        }
    }

    public static void printPersoner(Connection conn) throws  SQLException {
        String queryStatement = "SELECT * FROM Person";
        PreparedStatement prepStat = conn.prepareStatement(queryStatement);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()){
            System.out.println("ID: " + rs.getInt("personID") + ", navn: " + rs.getString("navn"));
        }
    }

    public static void printOvelser(Connection conn) throws SQLException{
        String queryStatement = "SELECT * FROM Ovelse";
        PreparedStatement prepStat = conn.prepareStatement(queryStatement);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()){
            for (Ovelsesgruppe g : getOvelsesgrupper(conn)) {
                if (rs.getInt("gruppeID") == g.getGruppeID()) {
                    System.out.println("ID: " + rs.getInt("ovelseID") + ", navn: " + rs.getString("navn") + " Øvelsesgruppe: " + g.getNavn());
                }
            }
        }
    }

    public static void printTreningsokter(Connection conn) throws SQLException {

        for (Treningsokt t : getTreningsOkter(conn)){
            if (t.getPartner() != null){
                System.out.println("ID: " + t.getOktID() + ", dato: " + t.getDato()+ ", tidspunkt: " + t.getTidspunkt() +
                        " treningspartner: " + t.getPartner().getNavn());
            }
            else{
                System.out.println("ID: " + t.getOktID() + ", dato: " + t.getDato()+ ", tidspunkt: " + t.getTidspunkt());
            }
        }
        /*
        String queryStatement = "SELECT * FROM Treningsokt";
        PreparedStatement prepStat = conn.prepareStatement(queryStatement);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()){
            System.out.println("ID: " + rs.getInt("oktID") + ", dato: " + rs.getString("dato")+
                    ", tidspunkt: " + rs.getString("tidspunkt"));
        }*/
    }

    public static void printOvelsesgrupper(Connection conn) throws SQLException {
        for (Ovelsesgruppe g : getOvelsesgrupper(conn)){
            System.out.println("ID: " + g.getGruppeID() + " navn: " + g.getNavn());
        }
    }
}
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    public static void addApparat(Connection conn, int apparatID, String navn, String beskrivelse) {
        
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

    
    public static void addFastmontert(Connection conn, String navn, int form, int prestasjon, int antallKg, int antallSett, Apparat apparat) {

        String queryOvelse = "INSERT INTO Ovelse (navn, form, prestasjon) VALUES (?,?,?)";
        String queryFastmontert = "INSERT INTO Fastmontert (ovelseID, antall_kg, antall_sett, apparat) VALUES (?,?,?,?)";
        

        try {
            PreparedStatement prepStatOvelse = conn.prepareStatement(queryOvelse);
            PreparedStatement prepStatFast = conn.prepareStatement(queryFastmontert);

            prepStatOvelse.setString(1, navn);
            prepStatOvelse.setInt(2, form);
            prepStatOvelse.setInt(3, prestasjon);

            prepStatFast.setInt(1, getHoyesteOvelseID(conn));
            prepStatFast.setInt(2, antallKg);
            prepStatFast.setInt(3, antallSett);
            prepStatFast.setInt(4, apparat.getApparatID());

            prepStatOvelse.execute();
            prepStatFast.execute();

            System.out.println("Fastmontert ovelse lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Fastmontert", e);
        }
    }

    public static List<Apparat> getApparater(Connection conn) throws SQLException{
        List<Apparat> apparater = new ArrayList<>();

        String queryStatement = "SELECT * FROM Apparat";
        PreparedStatement prepStat = conn.prepareStatement(queryStatement);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()){
            Apparat apparat = new Apparat(rs.getString("navn"), rs.getString("beskrivelse"));
            apparater.add(apparat);
        }
        return apparater;
    }


    public static List<Ovelse> getOvelser(Connection conn) throws SQLException {
        List<Ovelse> ovelser = new ArrayList<Ovelse>();
        
        String stmt = "select * from Frittstaende";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
            Ovelse o = new Frittstaende(rs.getInt("ovelseID"), rs.getString("navn"), rs.getInt("form"), 
                                        rs.getInt("prestasjon"), rs.getString("beskrivelse"));
            ovelser.add(o);
        }

        String stmt = "select * from Fastmontert";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()) {
            for(Apparat a : getApparater(conn)){
                if (a.getApparatID() == rs.getInt("apparat")){
                    Ovelse o = new Fastmontert(rs.getInt("ovelseID"), rs.getString("navn"), rs.getInt("form"), 
                                                rs.getInt("prestasjon"), rs.getInt("antall_kg"),rs.getInt("antall_sett"), a);
                    ovelser.add(o);
                }
            } 
        }
    }

    public static int getHoyesteOvelseID(Connection conn) throws SQLException {
        List<Ovelse> ovelser = getOvelser(conn);
        int storst = 0;
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
            if (rs.getInt("ovelseID") != null){
                for (Ovelse o : getOvelser(conn)){
                    if(o.getOvelseID() == rs.getInt("ovelseID")){
                        Person p = new Person(rs.getInt("personID"), rs.getString("navn"), rs.getInt("tlfnr"), o);
                        personer.add(p);
                    }
                }
            } else {
                Person p = new Person(rs.getInt("personID"), rs.getString("navn"), rs.getInt("tlfnr"));
                personer.add(p);
            }
        }
    }

    public static List<TreningsOkt> getTreningsOkter(Connection conn) throws SQLException{
    		
        List<TreningsOkt> treningsOkter = new ArrayList<TreningsOkt>();
        
        String stmt = "select * from Treningsokt";
        PreparedStatement prepStat = conn.prepareStatement(stmt);
        ResultSet rs = prepStat.executeQuery();
        
        while(rs.next()) {
            if (rs.getInt("personID") != null){
                for (Person p : getPersoner(conn)){
                    if (rs.getInt("personID") == p.getPersonID()){
                        TreningsOkt t = new TreningsOkt(rs.getInt("oktID") , rs.getDate("dato"), rs.getTime("tidspunkt"), 
                                                        rs.getInt("varighet"), rs.getString("notat"), p);
                        treningsOkter.add(t);
                    }
                }
            } else {
                TreningsOkt t = new TreningsOkt(rs.getInt("oktID") , rs.getDate("dato"), rs.getTime("tidspunkt"), 
                rs.getInt("varighet"), rs.getString("notat"));
            }
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
}
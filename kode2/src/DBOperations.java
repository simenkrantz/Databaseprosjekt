import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {



    public static void addApparat(Connection conn, int apparatID, String navn, String beskrivelse) {
        
        String query = "INSERT INTO Apparat (apparatID, navn, beskrivelse) VALUES (?,?,?)";
        
        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setInt(1, apparatID);
            prepStat.setString(2, navn);
            prepStat.setString(3, beskrivelse);

            prepStat.execute();

            System.out.println("Apparat lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Apparat", e);
            //System.out.println("DB error when inserting Apparat");
        }
    }

    
    public static void addFastmontert(Connection conn, String navn, int form, int prestasjon, int ovelseID, int antallKg, int antallSett, int apparatID) {

        String queryOvelse = "INSERT INTO Ovelse (ovelseID, navn, form, prestasjon) VALUES (?,?,?,?)";
        String queryFastmontert = "INSERT INTO Fastmontert (ovelseID, antall_kg, antall_sett, apparat) VALUES (?,?,?,?)";
        

        try {
            PreparedStatement prepStatOvelse = conn.prepareStatement(queryOvelse);
            PreparedStatement prepStatFast = conn.prepareStatement(queryFastmontert);

            prepStatOvelse.setInt(1, ovelseID);
            prepStatOvelse.setString(2, navn);
            prepStatOvelse.setInt(3, form);
            prepStatOvelse.setInt(4, prestasjon);

            prepStatFast.setInt(1, ovelseID);
            prepStatFast.setInt(2, antallKg);
            prepStatFast.setInt(3, antallSett);
            prepStatFast.setInt(4, apparatID);

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

    public static void printApparater(Connection conn) throws SQLException{
        String queryStatement = "SELECT * FROM Apparat";
        PreparedStatement prepStat = conn.prepareStatement(queryStatement);
        ResultSet rs = prepStat.executeQuery();

        while(rs.next()){
            System.out.println("ID: " + rs.getInt("apparatID") + ", navn: " + rs.getString("navn"));
        }
    }
}
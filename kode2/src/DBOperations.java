import java.sql.*;
import java.sql.Date;

public class DBOperations {



    public static void addApparat(Connection conn, Apparat apparat) {
        
        String query = "INSERT INTO Apparat (apparatID, navn, beskrivelse) VALUES (?,?,?)";
        
        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setInt(1, apparat.getApparatID());
            prepStat.setString(2, apparat.getNavn());
            prepStat.setString(3, apparat.getBeskrivelse());

            prepStat.execute();

            System.out.println("Apparat lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Apparat", e);
            //System.out.println("DB error when inserting Apparat");
        }
    }

    public static void addFastmontert(Connection conn, Fastmontert ovelse) {

        String queryOvelse = "INSERT INTO Ovelse (navn, form, prestasjon) VALUES (?,?,?)";
        String queryFastmontert = "INSERT INTO Fastmontert (ovelseID, antall_kg, antall_sett, apparat) VALUES (?,?,?,?)";
        

        try {
            PreparedStatement prepStatOvelse = conn.prepareStatement(queryOvelse);
            PreparedStatement prepStatFast = conn.prepareStatement(queryFastmontert);

            prepStatOvelse.setString(1, ovelse.getNavn());
            prepStatOvelse.setInt(2, ovelse.getForm());
            prepStatOvelse.setInt(3, ovelse.getPrestasjon());

            prepStatFast.setInt(1, ovelse.getOvelseID());
            prepStatFast.setInt(2, ovelse.getAntallKg());
            prepStatFast.setInt(3, ovelse.getAntallSett());
            prepStatFast.setInt(4, ovelse.getApparat().getApparatID());

            prepStatOvelse.execute();
            prepStatFast.execute();

            System.out.println("Fastmontert ovelse lagt til");

        } catch (Exception e) {
            System.out.println("DB error when inserting Fastmontert ovelse");
        }
    }

}
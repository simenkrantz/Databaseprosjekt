import java.sql.*;
import java.sql.Date;

public class DBOperations {



    public static void addApparat(Connection conn, Apparat apparat) {
        
        String query = "INSERT INTO Apparat (navn, beskrivelse) VALUES (?,?)";
        
        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setString(1, apparat.navn);
            prepStat.setString(2, apparat.beskrivelse);

            prepStat.execute();

            System.out.println("Apparat lagt til");

        } catch (Exception e) {
            System.out.println("DB error when inserting Apparat");
        }
    }

    
    public static void addFastmontert(Connection conn, Fastmontert ovelse) {

        String queryOvelse = "INSERT INTO Ovelse (navn, form, prestasjon) VALUES (?,?,?)";
        String queryFastmontert = "INSERT INTO Fastmontert (ovelseID, antall_kg, antall_sett, apparat) VALUES (?,?,?,?)";
        

        try {
            PreparedStatement prepStatOvelse = conn.prepareStatement(queryOvelse);
            PreparedStatement prepStatFast = conn.prepareStatement(queryFastmontert);

            prepStatOvelse.setString(1, ovelse.navn);
            prepStatOvelse.setInt(2, ovelse.form);
            prepStatOvelse.setInt(3, ovelse.prestasjon);

            prepStatFast.setInt(1, ovelse.getOvelseID());
            prepStatFast.setInt(2, ovelse.antallKg);
            prepStatFast.setInt(3, ovelse.antallSett);
            prepStatFast.setInt(4, ovelse.apparat.getApparatID());

            prepStatOvelse.execute();
            prepStatFast.execute();

            System.out.println("Fastmontert ovelse lagt til");

        } catch (Exception e) {
            System.out.println("DB error when inserting Fastmontert ovelse");
        }
    }

}
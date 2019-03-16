import java.sql.*;
import java.sql.Date;

public class DBOperations {



    public static void addApparat(Connection conn, Apparat apparat) {
        
        String query = "INSERT INTO apparat (navn, beskrivelse) VALUES (?,?)";
        
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

}
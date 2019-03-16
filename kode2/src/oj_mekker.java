import java.sql.*;
import java.sql.Date;

public class DBOperations {

    public static void addPerson(Connection conn, int personID, String navn, int telefonnummer, Ovelse favorittOvelse) {

        String query = "INSERT INTO Person (personID, navn, telefonNummer, favorittOvelse) VALUES (?,?,?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setInt(1, personID);
            prepStat.setString(2, navn);
            prepStat.setInt(3, telefonnummer);
            prepStat.setInt(4, favorittOvelse);

            prepStat.execute();

            System.out.println("Person lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Person", e);
            //System.out.println("DB error when inserting Person");
        }
    }

    public static void addOvelsesgruppe(Connection conn, int gruppeID, String navn) {

        String query = "INSERT INTO Ovelsesgruppe (gruppeID, navn) VALUES (?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setInt(1, gruppeID);
            prepStat.setString(2, navn);

            prepStat.execute();

            System.out.println("Ovelsesgruppe lagt til");

        } catch (Exception e) {
            throw new RuntimeException("DB error when inserting Ovelsesgruppe", e);
            //System.out.println("DB error when inserting Ovelsesgruppe");
        }
    }

}

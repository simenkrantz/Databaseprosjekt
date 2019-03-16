import java.sql.*;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DBOpOKTSKK {

    // Use case 1 -- register a workout with the corresponding data
    public static void addTreningsOkt(Connection conn, int oktID, java.sql.Date dato, java.sql.Time tidspunkt, int varighet, int partnerID, String notat) {
        String query = "INSERT INTO Treningsokt(oktID, dato, tidspunkt,varighet,treningspartner,notat) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);

            prepStat.setInt(1, oktID);
            prepStat.setDate(2, dato);
            prepStat.setTime(3, tidspunkt);
            prepStat.setInt(4, varighet)
            prepStat.setInt(5. partnerID);
            prepStat.setString(6, notat);

            prepStat.execute();

            System.out.println("Økt med ID " + String.valueOf(okt.getOktID()) + " lagt til.");

        }
        catch (Exception e) {
            throw new RuntimeException("Error ved inserting av økt", e);
        }
    }

    // Use case 2 -- information about the last workouts
    public void getLastWorkoutNotes(Connection conn) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv inn antall [int] siste treningsøkter: ");
        String temp = sc.nextLine();

        try {
            int num = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            System.out.println("Error, entry not an integer!");
            getLastWorkoutNotes(conn);
        }

        String query = "SELECT notat FROM Treningsokt";

        try {
            PreparedStatement prepStat = conn.prepareStatement(query);
            ResultSet rs = prepStat.executeQuery();
            int numOfRows = 0;
            while(rs.next()) {
                if(numOfRows > num) {
                    return;
                }
                String notat = rs.getString("notat");
                System.out.println(notat + "\n");
                numOfRows += 1;
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error ved innlesning av siste n økt", e);
        }
    }

}
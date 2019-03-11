package tdb;
import java.sql.*;
import java.util.*;

public class Apparat extends tdb.ActiveDomainObject {
    private static  int apparatID = 1;
    private String navn;
    private String beskrivelse;

    // Beskrivelse si assigned a default value
    public Apparat(int apparatID, String navn) {
        apparatID += 1;
        this.navn = navn;
        this.beskrivelse = "";
    }

    public Apparat(int apparatID, String navn, String beskrivelse) {
        apparatID += 1;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }

    // Get and set functionality
    public int getApparatID() {
        return apparatID;
    }
    public String getApparatNavn() {
        return navn;
    }
    public void setBeskrivelse(String desc) {
        beskrivelse = desc;
    }
    public String getBeskrivelse() {
        if (beskrivelse == "") {
            return "No description available";
        } else {
            return beskrivelse;
        }

    }

    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select navn, beskrivelse from Apparat where ApparatID=" + apparatID);
            while (rs.next()) {
                navn =  rs.getString("navn");
            }
        } catch (Exception e) {
            System.out.println("DB error during select of Apparat: " + e);
            return;
        }

    }

    @Override
    public void refresh (Connection conn) {
        initialize (conn);
    }

    @Override
    public void save (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into Apparat values (apparatID," + navn + "," + beskrivelse + ")");
        } catch (Exception e) {
            System.out.println("DB error during insert of Apparat="+e);
            return;
        }
    }



}

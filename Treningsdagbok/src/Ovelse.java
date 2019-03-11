/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdb;

import java.sql.*;
import java.util.*;

public abstract class Ovelse extends tdb.ActiveDomainObject {
    private static int ovelseID = 1;
    private String navn;
    private int gruppeID;
    private int form;
    private int prestasjon;

    public Ovelse (String navn, int gruppeID) {
        this.navn = navn;
        this.gruppeID = gruppeID;
        ovelseID += 1;
    }

    public int getOvelseID(){
        return ovelseID;
    }

    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select navn from Ovelse where ovelseID=" + ovelseID);
            while (rs.next()) {
                navn =  rs.getString("navn");
            }

        } catch (Exception e) {
            System.out.println("db error during select of Ovelse= "+e);
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
            stmt.executeUpdate("insert into Ovelse values (ovelseID,"+navn+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Ovelse="+e);
            return;
        }
    }
}
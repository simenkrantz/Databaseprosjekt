/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdb;

import java.sql.*;
import java.util.*;

public class Ovelsesgruppe extends tdb.ActiveDomainObject {
    private static int GruppeID = 1;
    private String navn;

    public Ovelsesgruppe (int gruppeID, String navn) {
        this.gruppeID = gruppeID;
        this.navn = navn;
        gruppeID += 1;
    }

    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select navn from Ovelsesgruppe where GruppeID =" + GruppeID);
            while (rs.next()) {
                navn =  rs.getInt("navn");
            }

        } catch (Exception e) {
            System.out.println("db error during select of Ovelsesgruppe= "+e);
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
            stmt.executeUpdate("insert into Ovelsesgruppe values (NULL,"+navn+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Ovelsesgruppe="+e);
            return;
        }
    }
}
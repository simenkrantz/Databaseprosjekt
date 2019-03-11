/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdb;

import java.sql.*;
import java.util.*;

public class Person extends tdb.ActiveDomainObject {
    private static int personID = 1;
    private String navn;
    private int telefonnummer;
    private tdb.Ovelse favorittOvelse;

    public Person (String navn, int telefonnummer, tdb.Ovelse favOv) {
        this.navn = navn;
        this.telefonnummer = telefonnummer;
        this.favorittOvelse = favOv;
        personID += 1;
    }

    public void setNavn(String navn){
        this.navn = navn;
    }
    public void setTelefonnummer(int nummer){
        this.telefonnummer = nummer;
    }
    public void setFavorittOvelse(tdb.Ovelse ovelse){
        this.favorittOvelse = ovelse;
    }

    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select navn, telefonnummer from Person where personID=" + personID);
            while (rs.next()) {
                navn =  rs.getString("navn");
                telefonnummer = rs.getInt("telefonnummer");
            }

        } catch (Exception e) {
            System.out.println("db error during select of Person= "+e);
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
            stmt.executeUpdate("insert into Person values (personID,"+navn+","+telefonnummer+","+favorittOvelse.getOvelseID()+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Person="+e);
            return;
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdb;

import java.sql.*;
import java.util.*;

public class Treningsokt extends tdb.ActiveDomainObject {
    private static int oktID = 1;
    private String dato;       //endre type?
    private String tidspunkt;  // endre type?
    private int varighet;
    private String notat;
    private tdb.Person treningspartner;
    private ArrayList<tdb.Ovelse> ovelser;

    public Treningsokt(String dato, String tidspunkt, int varighet, String notat) {
        this.dato =  dato;
        this.tidspunkt = tidspunkt;
        this.varighet = varighet;
        this.notat = notat;
        ovelser = new ArrayList<tdb.Ovelse>();
    }

    public Treningsokt(String dato, String tidspunkt, int varighet, tdb.Person partner, String notat) {
        this.dato =  dato;
        this.tidspunkt = tidspunkt;
        this.varighet = varighet;
        this.notat = notat;
        treningspartner = partner;
        ovelser = new ArrayList<tdb.Ovelse>();
    }


    public void regOvelse (String navn, int gruppeID, int form, int prestasjon, Connection conn) {
        tdb.Ovelse o = new tdb.Ovelse(navn, gruppeID, form, prestasjon);
        o.initialize (conn);
        ovelser.add(o);
    }

    public void regTid (int startTid, int timer) {
        this.startTid = startTid;
        this.timer = timer;
    }

    @Override
    public void initialize (Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs =
                    stmt.executeQuery(
                            "select dato, tidspunkt, varighet, notat, Person.navn, tlfnr, Ovelse.navn AS favorittovelse, Ovelse.gruppeID" +
                            "from (Treningsokt INNER JOIN Person ON Treningsokt.treningspartner = Person.personID)" +
                                    "INNER JOIN Ovelse ON Person.favorittovelse = Ovelse.ovelseID " +
                                    "where oktID=" + oktID);
            while (rs.next()) {
                this.dato = rs.getString("dato");
                this.tidspunkt = rs.getString("tidspunkt");
                this.varighet = rs.getInt("varighet");
                this.notat = rs.getString("notat");
                //this.treningspartner.setNavn(rs.getString("navn"));
                //this.treningspartner.setTelefonnummer(rs.getInt("tlfnr"));
                /*this.treningspartner =
                        new tdb.Person(rs.getString("navn"),
                                rs.getInt("tlfnr"),
                                new tdb.Ovelse(rs.getString("favorittovelse"),rs.getInt("gruppeID"));*/
                //HVORDAN SETTE FAVORITTØVELSE? LAGE NY OVELSE MED NEW?
            }

        } catch (Exception e) {
            System.out.println("db error during select of avtale= "+e);
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
            stmt.executeUpdate("insert into Avtale values (NULL,"+startTid+","+timer+","+type+")");
        } catch (Exception e) {
            System.out.println("db error during insert of Avtale="+e);
            return;
        }
        for (int i=0;i<brukere.size();i++) {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("insert into HarAvtale values ("+brukere.get(i).getBid()+",LAST_INSERT_ID())");
            } catch (Exception e) {
                System.out.println("db error during insert of HarAvtale="+e);
                return;
            }
        }
    }
}
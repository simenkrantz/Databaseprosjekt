/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdb;

import java.sql.*;
import java.util.*;

public class Treningsokt extends tdb.ActiveDomainObject {
    private static int oktID = 1;
    private int dato;
    private int tidspunkt;
    private int varighet;
    private String notat;
    private tdb.Person treningspartner;
    private ArrayList<tdb.Ovelse> ovelser;

    public Treningsokt (int startTid, int timer, int type) {
        aid = NOID;
        this.startTid = startTid;
        this.timer = timer;
        this.type = type;
        ovelser = new ArrayList<tdb.Ovelse>();
    }

    public void regOvelse (String navn, int gruppeID, Connection conn) {
        tdb.Ovelse o = new tdb.Ovelse(navn, gruppeID);
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
            ResultSet rs = stmt.executeQuery("select starttid, timer, alarmtype from Avtale where aid=" + aid);
            while (rs.next()) {
                startTid =  rs.getInt("starttid");
                timer = rs.getInt("timer");
                type = rs.getInt("avtaletype");
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
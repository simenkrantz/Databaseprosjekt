
package tdb;

import java.sql.*;
import java.util.*;

public class LagTreningsoktCtrl extends treningsdagbok.DBConn {
    private tdb.Treningsokt treningsokt;

    public LagTreningsoktCtrl () {
        connect();
        // La laging av treningsokt være en transaksjon
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("db error during setAuoCommit of LagTreningsoktCtrl="+e);
            return;
        }
    }

    public void lagTreningsokt (int startMTid, int sluttMTid){
        treningsokt = new tdb.Treningsokt(startMTid,0, tdb.Treningsokt);
        this.startMuligTid = startMTid;
        this.sluttMuligTid = sluttMTid;
    }
    public void velgBruker (int bid) {
        treningsokt.regBruker (bid, conn);
        // Vis hvilke tider som er aktuelle, gjør noe her .....
    }
    public void velgTidspunkt (int startTid, int antall) {
        treningsokt.regTid(startTid, antall);
    }
    public void lagAlarm (String alarmTekst) {

    }
    public void fullførAvtale () {
        treningsokt.save(conn);
        try {
            conn.commit();
        } catch (SQLException e) {
            System.out.println("db error during commit of LagAvtaleCtrl="+e);
            return;
        }
    }

}

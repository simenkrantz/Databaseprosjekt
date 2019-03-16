public class Treningsokt {
    static private int oktID = 1;
    private String dato;
    private String startTid;
    private int varighet;
    private String notat;
    private Person partner;

    public Treningsokt(String dato, String startTid, int varighet, String notat) {
        oktID += 1;
        this.date = dato;
        this.startTid = startTid;
        this.varighet = varighet;
        this.notat = notat;
        this.partner = null;
    }

    public Treningsokt(String dato, String startTid, int varighet, String notat, Person partner) {
        oktID += 1;
        this.dato = date;
        this.startTid = startTid;
        this.varighet = varighet;
        this.notat = notat;
        this.partner = partner;
    }

    public String getDate() {
        return dato;
    }

    public void setDate(String dato) {
        
    }
}

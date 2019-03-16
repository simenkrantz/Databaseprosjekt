public class Treningsokt {
    static private int oktID = 0;
    private java.sql.Date dato;
    private java.sql.Time startTid;
    private int varighet;
    private String notat;
    private Person partner;
    private List<Ovelse> ovelser;

    public Treningsokt(java.sql.Date dato, java.sql.Time startTid, int varighet) {
        oktID += 1;
        this.dato = dato;
        this.startTid = startTid;
        this.varighet = varighet;
        this.notat = "";
        this.partner = null;
        this.ovelser = new ArrayList<Ovelse>();
    }

    public Treningsokt(java.sql.Date dato, java.sql.Time startTid, int varighet, String notat, Person partner) {
        this.oktID = oktID;
        oktID += 1;
        this.dato = dato;
        this.startTid = startTid;
        this.varighet = varighet;
        this.notat = notat;
        this.partner = partner;
        this.ovelser = new ArrayList<Ovelse>();
    }

    public java.sql.Date getDato() { return dato; }

    public void setDato(java.sql.Date dato) { this.dato = dato; }

    public java.sql.Time getStartTid() { return startTid; }

    public void setStartTid(java.sql.Time tid) { startTid = tid; }

    public int getVarighet() { return startTid; }

    public void setVarighet(int minutter) { varighet = minutter; }

    public String getNotat() { return notat; }

    public void setNotat(String notat) { this.notat = notat; }

    public Person getPartner() { return partner; }

    public void setPartner(Person partner) { this.partner = partner; }

    public void addOvelse(Ovelse ovelse) { ovelser.add(ovelse); }

    public List<Ovelse> getOvelser() { return ovelser; }
}

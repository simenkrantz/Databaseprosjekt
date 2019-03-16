public class Treningsokt {
    static private int oktID = 1;
    private String dato;
    private String startTid;
    private int varighet;
    private String notat;
    private Person partner;
    private List<Ovelse> ovelser;

    public Treningsokt(String dato, String startTid, int varighet) {
        this.oktID += 1;
        this.dato = dato;
        this.startTid = startTid;
        this.varighet = varighet;
        this.notat = "";
        this.partner = null;
    }

    public Treningsokt(String dato, String startTid, int varighet, String notat, Person partner) {
        this.oktID += 1;
        this.dato = dato;
        this.startTid = startTid;
        this.varighet = varighet;
        this.notat = notat;
        this.partner = partner;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getStartTid() {
        return startTid;
    }

    public void setStartTid(String tid) {
        startTid = tid;
    }

    public int getVarighet() {
        return startTid;
    }

    public void setVarighet(int minutter) {
        varighet = minutter;
    }

    public String getNotat() {
        return notat;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }
}

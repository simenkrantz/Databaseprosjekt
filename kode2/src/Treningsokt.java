import java.util.ArrayList;
import java.util.List;

public class Treningsokt {
    private int oktID;
    private java.sql.Date dato;
    private java.sql.Time tidspunkt;
    private int varighet;
    private int form;
    private int prestasjon;
    private String notat;
    private Person partner;
    private List<Ovelse> ovelser;

    public Treningsokt(int oktID, java.sql.Date dato, java.sql.Time tidspunkt, int varighet) {
        this.oktID = oktID;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.varighet = varighet;
        this.notat = "";
        this.partner = null;
        this.ovelser = new ArrayList<Ovelse>();
    }

    public Treningsokt(int oktID, java.sql.Date dato, java.sql.Time tidspunkt, int varighet, int form, int prestasjon, String notat) {
        this.oktID = oktID;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.varighet = varighet;
        this.form = form;
        this.prestasjon = prestasjon;
        this.notat = notat;
        this.partner = null;
        this.ovelser = new ArrayList<Ovelse>();
    }

    public Treningsokt(int oktID, java.sql.Date dato, java.sql.Time tidspunkt, int varighet,int form, int prestasjon, String notat, Person partner) {
        this.oktID = oktID;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.varighet = varighet;
        this.form = form;
        this.prestasjon = prestasjon;
        this.notat = notat;
        this.partner = partner;
        this.ovelser = new ArrayList<Ovelse>();
    }

    public int getOktID() { return oktID; }

    public java.sql.Date getDato() { return dato; }

    public void setDato(java.sql.Date dato) { this.dato = dato; }

    public java.sql.Time getTidspunkt() { return tidspunkt; }

    public void setTidspunkt(java.sql.Time tid) { tidspunkt = tid; }

    public int getVarighet() { return varighet; }

    public void setVarighet(int minutter) { varighet = minutter; }

    public String getNotat() { return notat; }

    public void setNotat(String notat) { this.notat = notat; }

    public Person getPartner() { return partner; }

    public void setPartner(Person partner) { this.partner = partner; }

    public int getForm(){
        return form;
    }

    public void setForm(int form){
        this.form = form;
    }

    public int getPrestasjon(){
        return prestasjon;
    }

    public void setPrestasjon(int prestasjon){
        this.prestasjon = prestasjon;
    }

    public void addOvelse(Ovelse ovelse) { ovelser.add(ovelse); }

    public List<Ovelse> getOvelser() { return ovelser; }
}

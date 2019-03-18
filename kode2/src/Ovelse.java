
public class Ovelse {

    private int ovelseID;
    private String navn = null;
    private Ovelsesgruppe gruppe;

    public Ovelse(int ovelseID, String navn, Ovelsesgruppe gruppe){
        this.ovelseID = ovelseID;
        this.navn = navn;
        this.gruppe =  gruppe;
    }

    public int getOvelseID() {
        return ovelseID;
    }

    public String getNavn() {
        return navn;
    }

    public Ovelsesgruppe getGruppe() {return gruppe; }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
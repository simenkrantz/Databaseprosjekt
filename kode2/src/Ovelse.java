
public class Ovelse {

    private int ovelseID;
    private String navn = null;

    public Ovelse(int ovelseID, String navn){
        this.ovelseID = ovelseID;
        this.navn = navn;
    }

    public int getOvelseID() {
        return ovelseID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
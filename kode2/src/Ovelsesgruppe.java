public class Ovelsesgruppe {

    static private int gruppeID = 1;
    private String navn = null;

    public Ovelsesgruppe(String navn) {
        this.navn = navn;
        this.gruppeID = gruppeID;
        gruppeID += 1;
    }

    public String getNavn(){
        return this.navn;
    }
}

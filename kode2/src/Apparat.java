public class Apparat {

    static private int apparatID = 1;
    private String navn = null;
    private String beskrivelse = null;


    public Apparat(String navn, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.personID = apparatID;
        apparatID += 1;
    }

    public Apparat(String navn) {
        this.navn = navn;
        this.personID = apparatID;
        apparatID += 1;
    }

    public String getNavn(){
        return this.navn;
    }

    public int getBeskrivelse()){
        return this.beskrivelse
    }

    public void setBeskrivelse(Strimg beskrivelse){
        this.beskrivelse = beskrivelse;
        
    }
}

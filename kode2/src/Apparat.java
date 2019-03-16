public class Apparat {

    private int apparatID;
    private String navn = null;
    private String beskrivelse = null;


    public Apparat(int apparatID, String navn, String beskrivelse) {
        this.apparatID = apparatID;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }

    public Apparat(int apparatID, String navn) {
        this.apparatID = apparatID;
        this.navn = navn;
    }

    public int getApparatID() {
        return apparatID;
    }

    public String getNavn(){
        return this.navn;
    }

    public String getBeskrivelse(){
        return this.beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
        
    }
}

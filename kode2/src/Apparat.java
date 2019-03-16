public class Apparat {

    static private int apparatID = 0;
    private String navn = null;
    private String beskrivelse = null;


    public Apparat(String navn, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        apparatID += 1;
    }

    public Apparat(String navn) {
        this.navn = navn;
        apparatID += 1;
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


public class Frittstaende {
    private int ovelseID;
    private String beskrivelse = null;

    public Frittstaende(int ovelseID, String beskrivelse){
        this.ovelseID = ovelseID;
        this.beskrivelse = beskrivelse;
    }

    public String getBeskrivelse(){
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }
}
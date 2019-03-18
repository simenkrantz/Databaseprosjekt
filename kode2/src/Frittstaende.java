
public class Frittstaende extends Ovelse{

    private String beskrivelse = null;

    public Frittstaende(int ovelseID, String navn, String beskrivelse){
        super(ovelseID, navn);
        this.beskrivelse = beskrivelse;
    }

    public String getBeskrivelse(){
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }
}
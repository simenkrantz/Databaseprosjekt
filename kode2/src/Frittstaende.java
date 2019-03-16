
public class Frittstaende extends Ovelse{

    private String beskrivelse = null;

    public Frittstaende(String navn, String beskrivelse){
        super(navn);
        this.beskrivelse = beskrivelse;
    }

    public Frittstaende(String navn, int form, int prestasjon, String beskrivelse){
        super(navn, form, prestasjon);
        this.beskrivelse = beskrivelse;
    }

    public String getBeskrivelse(){
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Ovelsesgruppe {

    private int gruppeID;
    private String navn = null;
    private List<Ovelse> ovelser = new ArrayList<Ovelse>();

    public Ovelsesgruppe(int gruppeID, String navn){
        this.gruppeID = gruppeID;
        this.navn = navn;
    }

    public String getGruppeID() {return this.gruppeID;}

    public String getNavn() {return this.navn;}

    public List<Ovelse> getOvelser() {return this.ovelser;}
    
}

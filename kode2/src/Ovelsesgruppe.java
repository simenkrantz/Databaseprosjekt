import java.util.ArrayList;
import java.util.List;

public class Ovelsesgruppe {

    static private int gruppeID = 1;
    private String navn = null;
    private List<Ovelse> ovelser;

    public Ovelsesgruppe(String navn){
        ovelser = new ArrayList<Ovelse>();
        this.navn = navn;
        this.gruppeID = gruppeID;
        gruppeID += 1;
    }

    public String getNavn(){
        return this.navn;
    }

    public List<Ovelse> getOvelser(){
        return this.ovelser
    }
}

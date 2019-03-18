
public class Fastmontert extends Ovelse {

    private int antallKg;
    private int antallSett;
    private Apparat apparat;

    public Fastmontert(int ovelseID, String navn,Ovelsesgruppe gruppe, Apparat apparat){
        super(ovelseID, navn,gruppe);
        this.apparat = apparat;
    }

    public Fastmontert(int ovelseID, String navn,Ovelsesgruppe gruppe, int antallKg, int antallSett, Apparat apparat){
        super(ovelseID, navn, gruppe);
        this.antallKg = antallKg;
        this.antallSett = antallSett;
        this.apparat = apparat;
    }

    public int getAntallKg(){
        return antallKg;
    }

    public void setAntallKg(int kg){
        antallKg = kg;
    }

    public int getAntallSett(){
        return antallSett;
    }

    public void setAntallSett(int sett){
        antallSett = sett;
    }
    
    public Apparat getApparat(){
        return apparat;
    }

    public void setApparat(Apparat apparat){
        this.apparat = apparat;
    }
}

public class Fastmontert extends Ovelse {

    private int antallKg = null;
    private int antallSett = null;
    private Apparat apparat;

    public Fastmontert(String navn, Apparat apparat){
        super(navn);
        this.apparat = apparat;
    }

    public Fastmontert(String navn, int form, int prestasjon, int antallKg, int antallSett, Apparat apparat){
        super(navn, form, prestasjon);
        this.antallKg = antallKg;
        this.antallSett = antallSett;
        this.apparat = apparat;
    }

    public String getAntallKg(){
        return antallKg;
    }

    public void setAntallKg(int kg){
        antallKg = kg;
    }

    public String getAntallSett(){
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
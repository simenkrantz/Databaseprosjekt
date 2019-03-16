public class Person {

    static private int personID = 0;
    private String navn;
    private int telefonNummer;
    private Ovelse favorittOvelse;


    public Person(String navn, String telefonNummer, Ovelse favorittOvelse) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.favorittOvelse = favorittOvelse;
        this.personID = personID;
        personID += 1;
    }

    public Person(String navn) {
        this.navn = navn;
        this.personID = personID;
        personID += 1;
    }

    public String getNavn(){
        return this.navn;
    }

    public int getTelefonNummer(){
        return this.telefonNummer
    }

    public Ovelse getFavorittOvelse(){
        return this.favorittOvelse
    }

    public void setTelefonNummer(int telefonNummer){
        this.telefonNummer = telefonNummer;
    }

    public void setFavorittOvelse(Ovelse favorittOvelse){
        this.telefonNummer = telefonNummer;
    }
}

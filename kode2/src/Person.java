public class Person {

    static private int personID = 1;
    private String navn = null;
    private int telefonNummer;
    private Ovelse favorittOvelse = null;


    public Person(String navn, int telefonNummer, Ovelse favorittOvelse) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.favorittOvelse = favorittOvelse;
        personID += 1;
    }

    public Person(String navn) {
        this.navn = navn;
        personID += 1;
    }

    public String getPersonID() {return this.personID;}

    public String getNavn() {return this.navn;}

    public int getTelefonNummer() {return this.telefonNummer;}

    public Ovelse getFavorittOvelse() {return this.favorittOvelse;}

    public void setTelefonNummer(int telefonNummer) {this.telefonNummer = telefonNummer;}

    public void setFavorittOvelse(Ovelse favorittOvelse) {this.telefonNummer = telefonNummer;}
}

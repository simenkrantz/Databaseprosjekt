public class Person {

    private int personID;
    private String navn = null;
    private int telefonNummer;
    private Ovelse favorittOvelse = null;


    public Person(int personID, String navn, int telefonNummer, Ovelse favorittOvelse) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.favorittOvelse = favorittOvelse;
        this.personID = personID;
    }

    public Person(int personID, String navn, int telefonNummer) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.personID = personID;
    }

    public Person(int personID, String navn) {
        this.navn = navn;
        this.personID = personID;
    }

    public int getPersonID() {return this.personID;}

    public String getNavn() {return this.navn;}

    public int getTelefonNummer() {return this.telefonNummer;}

    public Ovelse getFavorittOvelse() {return this.favorittOvelse;}

    public void setTelefonNummer(int telefonNummer) {this.telefonNummer = telefonNummer;}

    public void setFavorittOvelse(Ovelse favorittOvelse) {this.telefonNummer = telefonNummer;}
}

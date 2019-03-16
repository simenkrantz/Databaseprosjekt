
public class Ovelse {

    static private int ovelseID = 1;
    private String navn = null;
    private int form;
    private int prestasjon;

    public Ovelse(String navn){
        ovelseID += 1;
        this.navn = navn;
    }

    public Ovelse(String navn, int form, int prestasjon) {
        ovelseID += 1;
        this.navn = navn;
        this.form = form;
        this.prestasjon = prestasjon;
    }

    public int getOvelseID() {
        return ovelseID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getForm(){
        return form;
    }

    public void setForm(int form){
        this.form = form;
    }

    public int getPrestasjon(){
        return prestasjon;
    }

    public void setPrestasjon(int prestasjon){
        this.prestasjon = prestasjon;
    }

}
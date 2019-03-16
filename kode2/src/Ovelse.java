
public class Ovelse {

    private int ovelseID;
    private String navn = null;
    private int form;
    private int prestasjon;

    public Ovelse(int ovelseID, String navn){
        this.ovelseID = ovelseID;
        this.navn = navn;
    }

    public Ovelse(int ovelseID, String navn, int form, int prestasjon) {
        this.ovelseID = ovelseID;
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
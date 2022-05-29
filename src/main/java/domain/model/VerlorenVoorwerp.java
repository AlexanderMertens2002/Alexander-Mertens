package domain.model;

import java.util.Date;

public class VerlorenVoorwerp{
    private String Beschrijving;
    private int Jaar;
    private String Plaats;
    private int Telefoonnr;
    private String Email;
    private int Maand;
    private int Dag;

    public VerlorenVoorwerp(String beschrijving, int jaar,int maand,int dag, String plaats, int telefoonnr, String email){
        setBeschrijving(beschrijving);
        setJaar(jaar);
        setMaand(maand);
        setDag(dag);
        setPlaats(plaats);
        setTelefoonnr(telefoonnr);
        setEmail(email);

    }

    public VerlorenVoorwerp() {

    }


    public void setBeschrijving(String beschrijving) {
        this.Beschrijving = beschrijving;
    }

    public void setJaar(int jaar) {
        this.Jaar = jaar;
    }

    public void setMaand(int maand) {
        this.Maand = maand;
    }

    public void setDag(int dag) {
        this.Dag = dag;
    }

    public void setPlaats(String plaats) {
        this.Plaats = plaats;
    }

    public void setTelefoonnr(int telefoonnr) {
        this.Telefoonnr = telefoonnr;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getBeschrijving(){
        return Beschrijving;
    }

    public int getJaar() {return Jaar;}

    public int getMaand() {return Maand;}

    public int getDag() {return Dag;}

    public int  getTelefoonnr() {
        return Telefoonnr;
    }

    public String getEmail() {
        return Email;
    }

    public String getPlaats() {
        return Plaats;
    }

    public String getDatum(){
        return getDag() + "/"+ getMaand()+"/"+ getJaar();
    }

    public String toonBeschrijving() {
        return this.getBeschrijving() + " verloren in " + this.getPlaats() + " op " +getDatum();

    }
}

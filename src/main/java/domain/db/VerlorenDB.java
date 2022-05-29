package domain.db;

import domain.DomainException;
import domain.model.VerlorenVoorwerp;

import java.util.ArrayList;

public class VerlorenDB {
    private ArrayList<VerlorenVoorwerp> verlorenlijst = new ArrayList<>();



    public VerlorenDB() {
        VerlorenVoorwerp grijzekat = new VerlorenVoorwerp("Grijze kat", 2020,3,5, "Mechelen", 04666666, "bob@email.com");
        VerlorenVoorwerp blauweBall = new VerlorenVoorwerp("Blauwe ball", 2021,7,21, "Leuven", 04777777, "gert@email.com");
        VerlorenVoorwerp geleFiets = new VerlorenVoorwerp("gele fiets", 2022,1,1, "Mechelen", 04555555, "bob@email.com");

        verlorenlijst.add(grijzekat);
        verlorenlijst.add(blauweBall);
        verlorenlijst.add(geleFiets);
    }

    public void voegToe(VerlorenVoorwerp verlorenVoorwerp) {
        verlorenlijst.add(verlorenVoorwerp);
    }

    public VerlorenVoorwerp find(String beschrijving) {
        for (VerlorenVoorwerp verlorenVoorwerp : verlorenlijst) {
            if (verlorenVoorwerp.getBeschrijving().equalsIgnoreCase(beschrijving)) {
                return verlorenVoorwerp;
            }
        }
        return null;
    }

    public void Remove(String beschrijving){
        verlorenlijst.remove(find(beschrijving));
    }

    public VerlorenVoorwerp oudste(){
        VerlorenVoorwerp oudste = null;
        for (VerlorenVoorwerp verlorenVoorwerp : verlorenlijst) {
            if (oudste == null){
                oudste = verlorenVoorwerp;
            }
            else {
                if (oudste.getJaar() > verlorenVoorwerp.getJaar() ){
                    oudste = verlorenVoorwerp;
                }
                else if (oudste.getJaar() == verlorenVoorwerp.getJaar()){
                    if (oudste.getMaand() < oudste.getMaand()){
                        oudste = verlorenVoorwerp;
                    }
                    else if (oudste.getMaand() == oudste.getMaand()){
                        if (oudste.getDag() < verlorenVoorwerp.getDag()){
                            oudste = verlorenVoorwerp;
                        }
                    }
                }
            }
        }
        return oudste;
    }


    public ArrayList<VerlorenVoorwerp> getAlle() {
        return verlorenlijst;
    }
}

package model;

public class Persoon {
    private String naam;


    public Persoon(String nm){
        this.naam = nm;

    }

    public String getNaam(){
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

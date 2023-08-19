package model;

public class Ingredient {
    private String naam;

    public Ingredient(String nm){
        this.naam = nm;
    }

    public String getNaam(){
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

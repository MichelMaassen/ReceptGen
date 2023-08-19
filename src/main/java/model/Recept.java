package model;

import java.util.ArrayList;

public class Recept {
    private String receptNaam;
    private String beschrijving;
    private ArrayList<Ingredient> ingredienten = new ArrayList<>();
    private ArrayList<Recept> Recepten = new ArrayList<>();
    public Recept(String rnm, String bsch, ArrayList ing){
        this.receptNaam = rnm;
        this.beschrijving = bsch;
        this.ingredienten = ing;

    }

    public String getNaam(){
        return this.receptNaam;
    }

    public String getBeschrijving(){
        return this.beschrijving;
    }

    public ArrayList<Ingredient> getIngredienten(){
    return ingredienten; }

    public void setIngredienten(ArrayList<Ingredient> ingredienten){
        this.ingredienten = ingredienten;
    }

    public ArrayList<Recept> getRecepten() {
        return Recepten;
    }

    public void setRecepten(ArrayList<Recept> recepten) {
        Recepten = recepten;
    }
}
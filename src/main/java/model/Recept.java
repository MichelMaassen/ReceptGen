package model;

import java.util.ArrayList;

public class Recept {
    public String receptNaam;
    public String beschrijving;
    public ArrayList<Ingredient> ingredienten = new ArrayList();

    public Recept(String receptNaam, String beschrijving, ArrayList<Ingredient> ingredienten) {
        this.receptNaam = receptNaam;
        this.beschrijving = beschrijving;
        this.ingredienten = ingredienten;
    }
}
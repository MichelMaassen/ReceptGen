package webservices;
import DataManager.DataManager;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

import model.Ingredient;
import model.Recept;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;



@Path("/recepten")
public class ReceptResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecepten(@QueryParam("ingredient") String filter){
        ArrayList<Recept> recepten = createDefaultRecepten();

        if (filter != null) {
            ArrayList<Recept> gefilterdeRecepten = new ArrayList<Recept>();
            // Loop door recepten en kijk of één van de ingrediënten onderdeel is. Zoja, dan toevoegen aan gefilterde recepten.
            for (int i = 0; i < recepten.size(); i++) {
                Recept recept = recepten.get(i);
                for (int j = 0; j < recept.ingredienten.size(); j++) {
                    Ingredient ingredient =  recept.ingredienten.get(j);
                    if (ingredient.getNaam().toLowerCase().contains(filter.toLowerCase())) {
                        gefilterdeRecepten.add(recept);
                    }
                }
            }
            recepten = gefilterdeRecepten;
        }

        return Response.ok(recepten).build();
    }

    @POST
    @Path("/nieuwrecept")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createRecept(@FormParam("receptNaam") String receptNaam,
                                 @FormParam("ingredienten") String ingredienten,
                                 @FormParam("beschrijving") String beschrijving)
    {
        // Valideer dat juiste receptinformatie binnenkomt.
        if ((receptNaam == null) || ingredienten == null || beschrijving == null) {
            return  Response.serverError().build();
        }

        return  Response.ok().build();
    }

    // Maak een lijst van recepten
    private ArrayList<Recept> createDefaultRecepten() {
        ArrayList<Recept> recepten = new ArrayList<Recept>();

        ArrayList<Ingredient> ingredienten1 = new ArrayList<Ingredient>();
        ingredienten1.add(new Ingredient("Tomaat"));
        ingredienten1.add(new Ingredient("Water"));
        recepten.add(new Recept("Tomatensoep", "Bak de tomaten en plet ze voeg water toe tot het kookt. serveer nu lekker de tomatensoep.", ingredienten1));


        ArrayList<Ingredient> ingredienten2 = new ArrayList<Ingredient>();
        ingredienten2.add(new Ingredient("Ui"));
        ingredienten2.add(new Ingredient("Pasta"));
        ingredienten2.add(new Ingredient("Kaas"));
        recepten.add(new Recept("Kaas ui Pasta", "Kook de pasta, bak de ui en rasp de kaas. nadat de pasta is gekookt giet je het af en voeg je alle ingredienten samen.", ingredienten2));

        ArrayList<Ingredient> ingredienten3 = new ArrayList<Ingredient>();
        ingredienten3.add(new Ingredient("Prei"));
        ingredienten3.add(new Ingredient("Mayonaise"));
        recepten.add(new Recept("Prei salade", "Snijd de prei fijn en voeg de mayonaise toe. Serveer als frisse prei salade.", ingredienten3));

        return recepten;
    }
}

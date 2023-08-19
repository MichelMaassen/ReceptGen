package webservices;
import model.Recept;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("recepten")
public class ReceptResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlleRecepten(){
        Recept recept =

    }

    @Path("nieuwrecept")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Recept createRecept(@FormParam("receptNaam") String receptNaam,
                           @FormParam("ingredienten") String ingredienten,
                           @FormParam("beschrijving") String beschrijving,)
                           {
        Recept recept = new Recept(receptNaam,  beschrijving, ingredienten);


        return recept;
    }
}


package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.Person;
import facade.EntityFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

@Path("person")
public class PersonService {

    @Context
    private UriInfo context;
    private EntityFacade facade;
    
    public PersonService() {
        facade = new EntityFacade(Persistence.createEntityManagerFactory("CA2WebPU"));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getJson(@PathParam("id") int id) {   
       Person person =  facade.findPerson(id);
       PersonDTO dto = new PersonDTO(person.getEmail(), person.getFirstName(), person.getLastName(), person.getAddress().getStreet(), person.getAddress().getAdditionalInfo(), person.getAddress().getCityInfo().getzip());
       String personsAsJson = new Gson().toJson(dto);      
       return personsAsJson;
    }
    
    
    @GET
    @Produces("application/json")
    public String getAllJson() {   
      
       List<Person> persons =  facade.getPersons();
       JsonArray ja = new JsonArray();
        for (Person p : persons) {
            JsonObject jo = new JsonObject();
            jo.addProperty("firstName", p.getFirstName());
            jo.addProperty("lastName", p.getLastName());
            jo.addProperty("email", p.getEmail());
            jo.addProperty("street", p.getAddress().getStreet());
            jo.addProperty("additionalInfo", p.getAddress().getAdditionalInfo());
            jo.addProperty("zip", p.getAddress().getCityInfo().getzip());
            ja.add(jo);
            System.out.println(jo.toString());
        }
     //  PersonDTO dto = new PersonDTO(person.getEmail(), person.getFirstName(), person.getLastName(), person.getAddress().getStreet(), person.getAddress().getAdditionalInfo(), person.getAddress().getCityInfo().getzip());
       String personsAsJson = new Gson().toJson(ja);      
       return personsAsJson;
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @DELETE
     @Path("{id}")
    @Consumes("application/json")
    public void deleteperson(@PathParam("id") int id){
        // get id
        facade.deletePerson(id);
        return;
        // call delete method from facade
        // return status
        
        
    }
}

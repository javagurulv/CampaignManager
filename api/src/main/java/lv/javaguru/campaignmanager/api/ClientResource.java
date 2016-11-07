package lv.javaguru.campaignmanager.api;

import lv.javaguru.campaignmanager.api.dto.ClientDTO;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface ClientResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/clients")
    ClientDTO create(ClientDTO clientDTO);

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/clients/{clientId}")
    ClientDTO get(@PathParam("clientId") Long clientId);

}

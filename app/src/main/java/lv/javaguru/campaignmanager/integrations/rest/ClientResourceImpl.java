package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.ClientResource;
import lv.javaguru.campaignmanager.api.RESTResource;
import lv.javaguru.campaignmanager.api.dto.ClientDTO;
import lv.javaguru.campaignmanager.core.commands.clients.CreateClientCommand;
import lv.javaguru.campaignmanager.core.commands.clients.CreateClientResult;
import lv.javaguru.campaignmanager.core.commands.clients.GetClientCommand;
import lv.javaguru.campaignmanager.core.commands.clients.GetClientResult;
import lv.javaguru.campaignmanager.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class ClientResourceImpl implements ClientResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public ClientResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/clients")
    public ClientDTO create(ClientDTO clientDTO) {
        CreateClientCommand command = new CreateClientCommand(
                clientDTO.getLogin(), clientDTO.getPassword()
        );
        CreateClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/clients/{clientId}")
    public ClientDTO get(@PathParam("clientId") Long clientId) {
        GetClientCommand command = new GetClientCommand(clientId);
        GetClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

}

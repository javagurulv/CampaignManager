package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.RESTResource;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.CreateCampaignGroupCommand;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.CreateCampaignGroupResult;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.GetCampaignGroupCommand;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.GetCampaignGroupResult;
import lv.javaguru.campaignmanager.core.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class CampaignGroupResourceImpl {

    private CommandExecutor commandExecutor;

    @Autowired
    public CampaignGroupResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups")
    public Response create(CampaignGroupDTO campaignGroupDTO) {
        CreateCampaignGroupCommand command = new CreateCampaignGroupCommand(
                campaignGroupDTO.getTitle()
        );
        CreateCampaignGroupResult result = commandExecutor.execute(command);
        return Response.status(201).entity(result.getCampaignGroup()).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    public Response get(Long campaignGroupId) {
        GetCampaignGroupCommand command = new GetCampaignGroupCommand(
                campaignGroupId
        );
        GetCampaignGroupResult result = commandExecutor.execute(command);
        return Response.status(200).entity(result.getCampaignGroup()).build();
    }

}

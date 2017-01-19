package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.RESTResource;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.*;
import lv.javaguru.campaignmanager.core.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class CampaignGroupResourceImpl {

    @Autowired private CommandExecutor commandExecutor;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups")
    public Response create(CampaignGroupDTO campaignGroup) {
        CreateCampaignGroupCommand command = new CreateCampaignGroupCommand(
                new GroupTitle(campaignGroup.getTitle())
        );
        CreateCampaignGroupResult result = commandExecutor.execute(command);
        return Response.status(Response.Status.CREATED).entity(result.getCampaignGroup()).build();
    }

    @PUT
    @Consumes(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    public Response edit(@PathParam("campaignGroupId") Long campaignGroupId,
                         CampaignGroupDTO campaignGroup) {
        EditCampaignGroupCommand editCommand = new EditCampaignGroupCommand(
                new CampaignGroupId(campaignGroupId),
                new GroupTitle(campaignGroup.getTitle())
        );
        commandExecutor.execute(editCommand);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    public Response get(@PathParam("campaignGroupId") Long campaignGroupId) {
        GetCampaignGroupCommand command = new GetCampaignGroupCommand(
                new CampaignGroupId(campaignGroupId)
        );
        GetCampaignGroupResult result = commandExecutor.execute(command);
        return Response.status(Response.Status.OK).entity(result.getCampaignGroup()).build();
    }

}

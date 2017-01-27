package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.RESTResource;
import lv.javaguru.campaignmanager.api.dto.CreateCampaignGroupRequest;
import lv.javaguru.campaignmanager.api.dto.EditCampaignGroupRequest;
import lv.javaguru.campaignmanager.core.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.core.vo.GroupTitle;
import lv.javaguru.campaignmanager.core.CommandExecutor;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.CreateCampaignGroupCommand;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.CreateCampaignGroupResult;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.EditCampaignGroupCommand;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.GetCampaignGroupCommand;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.GetCampaignGroupResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public Response create(CreateCampaignGroupRequest request) {
        CreateCampaignGroupCommand command = new CreateCampaignGroupCommand(
                new GroupTitle(request.getGroupTitle())
        );
        CreateCampaignGroupResult result = commandExecutor.execute(command);
        return Response.status(Response.Status.CREATED).entity(result.getCampaignGroup()).build();
    }

    @PUT
    @Consumes(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    public Response edit(@PathParam("campaignGroupId") Long campaignGroupId,
                         EditCampaignGroupRequest editGroupRequest) {
        EditCampaignGroupCommand editCommand = new EditCampaignGroupCommand(
                new CampaignGroupId(campaignGroupId),
                new GroupTitle(editGroupRequest.getNewGroupTitle())
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

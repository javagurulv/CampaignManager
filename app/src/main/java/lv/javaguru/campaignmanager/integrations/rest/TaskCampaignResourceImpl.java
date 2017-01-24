package lv.javaguru.campaignmanager.integrations.rest;

import lv.javaguru.campaignmanager.api.RESTResource;
import lv.javaguru.campaignmanager.api.dto.CreateTaskCampaignRequest;
import lv.javaguru.campaignmanager.api.vo.CampaignGroupId;
import lv.javaguru.campaignmanager.api.vo.CampaignTitle;
import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.CommandExecutor;
import lv.javaguru.campaignmanager.core.commands.campaigns.task.ActivateTaskCampaignCommand;
import lv.javaguru.campaignmanager.core.commands.campaigns.task.CreateTaskCampaignCommand;
import lv.javaguru.campaignmanager.core.commands.campaigns.task.CreateTaskCampaignResult;
import lv.javaguru.campaignmanager.core.commands.campaigns.task.DeactivateTaskCampaignCommand;
import lv.javaguru.campaignmanager.core.commands.campaigns.task.GetTaskCampaignCommand;
import lv.javaguru.campaignmanager.core.commands.campaigns.task.GetTaskCampaignResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class TaskCampaignResourceImpl {

    @Autowired private CommandExecutor commandExecutor;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/taskCampaigns")
    public Response create(CreateTaskCampaignRequest request) {
        CreateTaskCampaignCommand command = new CreateTaskCampaignCommand(
                new CampaignGroupId(request.getCampaignGroupId()),
                new CampaignTitle(request.getCampaignTitle())
        );
        CreateTaskCampaignResult result = commandExecutor.execute(command);
        return Response.status(Response.Status.CREATED).entity(result.getTaskCampaign()).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/taskCampaigns/{taskCampaignId}")
    public Response get(@PathParam("taskCampaignId") Long taskCampaignId) {
        GetTaskCampaignCommand command = new GetTaskCampaignCommand(
                new TaskCampaignId(taskCampaignId)
        );
        GetTaskCampaignResult result = commandExecutor.execute(command);
        return Response.status(Response.Status.OK).entity(result.getTaskCampaign()).build();
    }

    @POST
    @Path("/taskCampaigns/{taskCampaignId}/activate")
    public Response activate(@PathParam("taskCampaignId") Long taskCampaignId) {
        ActivateTaskCampaignCommand command = new ActivateTaskCampaignCommand(
                new TaskCampaignId(taskCampaignId)
        );
        commandExecutor.execute(command);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/taskCampaigns/{taskCampaignId}/deactivate")
    public Response deactivate(@PathParam("taskCampaignId") Long taskCampaignId) {
        DeactivateTaskCampaignCommand command = new DeactivateTaskCampaignCommand(
                new TaskCampaignId(taskCampaignId)
        );
        commandExecutor.execute(command);
        return Response.status(Response.Status.OK).build();
    }

}

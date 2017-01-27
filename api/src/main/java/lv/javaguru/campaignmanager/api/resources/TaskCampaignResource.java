package lv.javaguru.campaignmanager.api.resources;

import lv.javaguru.campaignmanager.api.RESTResource;
import lv.javaguru.campaignmanager.api.dto.CreateTaskCampaignRequest;
import lv.javaguru.campaignmanager.api.dto.TaskCampaignDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface TaskCampaignResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/taskCampaigns")
    TaskCampaignDTO create(CreateTaskCampaignRequest request);

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/taskCampaigns/{taskCampaignId}")
    TaskCampaignDTO get(@PathParam("taskCampaignId") Long taskCampaignId);

    @POST
    @Path("/taskCampaigns/{taskCampaignId}/activate")
    void activate(@PathParam("taskCampaignId") Long taskCampaignId);

    @POST
    @Path("/taskCampaigns/{taskCampaignId}/deactivate")
    void deactivate(@PathParam("taskCampaignId") Long taskCampaignId);

    @POST
    @Path("/taskCampaigns/{taskCampaignId}/close")
    void close(@PathParam("taskCampaignId") Long taskCampaignId);

}

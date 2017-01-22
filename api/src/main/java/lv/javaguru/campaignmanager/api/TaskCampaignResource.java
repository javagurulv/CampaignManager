package lv.javaguru.campaignmanager.api;

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

}

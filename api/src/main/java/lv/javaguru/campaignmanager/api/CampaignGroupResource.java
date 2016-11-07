package lv.javaguru.campaignmanager.api;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface CampaignGroupResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups")
    CampaignGroupDTO create(CampaignGroupDTO campaignGroupDTO);

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    CampaignGroupDTO get(@PathParam("campaignGroupId") Long campaignGroupId);

}

package lv.javaguru.campaignmanager.api;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface CampaignGroupResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups")
    CampaignGroupDTO create(CampaignGroupDTO campaignGroup);

    @PUT
    @Consumes(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    void edit(@PathParam("campaignGroupId") Long campaignGroupId,
              CampaignGroupDTO campaignGroup);

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    CampaignGroupDTO get(@PathParam("campaignGroupId") Long campaignGroupId);

}

package lv.javaguru.campaignmanager.api.resources;

import lv.javaguru.campaignmanager.api.RESTResource;
import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import lv.javaguru.campaignmanager.api.dto.CreateCampaignGroupRequest;
import lv.javaguru.campaignmanager.api.dto.EditCampaignGroupRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface CampaignGroupResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups")
    CampaignGroupDTO create(CreateCampaignGroupRequest createGroupRequest);

    @PUT
    @Consumes(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    void edit(@PathParam("campaignGroupId") Long campaignGroupId,
              EditCampaignGroupRequest editGroupRequest);

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    CampaignGroupDTO get(@PathParam("campaignGroupId") Long campaignGroupId);

}

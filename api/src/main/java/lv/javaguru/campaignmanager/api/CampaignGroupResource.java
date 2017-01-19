package lv.javaguru.campaignmanager.api;

import lv.javaguru.campaignmanager.api.dto.CampaignGroupDTO;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface CampaignGroupResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups")
    CampaignGroupDTO create(CampaignGroupDTO campaignGroupDTO);

    @PUT
    @Consumes(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    CampaignGroupDTO edit(@PathParam("campaignGroupId") Long campaignGroupId,
                          @FormParam("newGroupTitle") String newGroupTitle);

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups/{campaignGroupId}")
    CampaignGroupDTO get(@PathParam("campaignGroupId") Long campaignGroupId);

}

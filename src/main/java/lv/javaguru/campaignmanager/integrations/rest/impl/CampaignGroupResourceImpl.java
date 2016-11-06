package lv.javaguru.campaignmanager.integrations.rest.impl;

import lv.javaguru.campaignmanager.core.commands.campaigngroups.CreateCampaignGroupCommand;
import lv.javaguru.campaignmanager.core.commands.campaigngroups.CreateCampaignGroupResult;
import lv.javaguru.campaignmanager.core.services.CommandExecutor;
import lv.javaguru.campaignmanager.integrations.rest.api.CampaignGroupResource;
import lv.javaguru.campaignmanager.integrations.rest.api.RESTResource;
import lv.javaguru.campaignmanager.integrations.rest.dto.CampaignGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class CampaignGroupResourceImpl implements CampaignGroupResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public CampaignGroupResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }


    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/campaignGroups")
    public CampaignGroupDTO create(CampaignGroupDTO campaignGroupDTO) {
        CreateCampaignGroupCommand command = new CreateCampaignGroupCommand(
                campaignGroupDTO.getTitle()
        );
        CreateCampaignGroupResult result = commandExecutor.execute(command);
        return result.getCampaignGroup();
    }

}

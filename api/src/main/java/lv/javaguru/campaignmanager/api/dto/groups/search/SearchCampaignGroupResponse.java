package lv.javaguru.campaignmanager.api.dto.groups.search;

import lv.javaguru.campaignmanager.api.dto.groups.CampaignGroupDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class SearchCampaignGroupResponse implements Serializable {

    private List<CampaignGroupDTO> groups;
    private Optional<Integer> totalCount;

}

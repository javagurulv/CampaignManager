package lv.javaguru.campaignmanager.core.domain.builders;

import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import org.junit.Test;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;
import static lv.javaguru.campaignmanager.core.domain.builders.TaskCampaignBuilder.createTaskCampaign;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TaskCampaignBuilderTest {

    private static final Long ID = 1L;

    @Test
    public void shouldCreateTaskCampaignWithId() {
        TaskCampaign taskCampaign = createTaskCampaign().withId(ID).build();
        assertThat(taskCampaign.getId(), is(ID));
    }

    @Test
    public void shouldCreateTaskCampaignWithCampaign() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign().build()
                ).build();
        assertThat(taskCampaign.getCampaign(), is(notNullValue()));
    }

    @Test
    public void shouldCreateTaskCampaignWithCampaignBuilder() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                ).build();
        assertThat(taskCampaign.getCampaign(), is(notNullValue()));
    }

}

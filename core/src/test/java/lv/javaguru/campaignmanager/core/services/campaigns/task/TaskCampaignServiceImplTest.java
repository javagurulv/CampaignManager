package lv.javaguru.campaignmanager.core.services.campaigns.task;

import lv.javaguru.campaignmanager.api.vo.TaskCampaignId;
import lv.javaguru.campaignmanager.core.domain.CampaignState;
import lv.javaguru.campaignmanager.core.domain.TaskCampaign;
import lv.javaguru.campaignmanager.core.domain.repositories.EntityRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.campaignmanager.core.domain.builders.CampaignBuilder.createCampaign;
import static lv.javaguru.campaignmanager.core.domain.builders.CampaignGroupBuilder.createCampaignGroup;
import static lv.javaguru.campaignmanager.core.domain.builders.TaskCampaignBuilder.createTaskCampaign;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class TaskCampaignServiceImplTest {

    @Mock private EntityRepository entityRepository;

    @InjectMocks
    private TaskCampaignService service = new TaskCampaignServiceImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static final Long CAMPAIGN_ID = 1L;
    private static final TaskCampaignId TASK_CAMPAIGN_ID = new TaskCampaignId(CAMPAIGN_ID);


    @Test
    public void shouldNotAllowActivateWhenCampaignIsNull() {
        TaskCampaign taskCampaign = createTaskCampaign().build();
        assertThat(taskCampaign.getCampaign(), is(nullValue()));
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Campaign must be defined");
        service.activate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldNotAllowActivateWhenNoGroup() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                ).build();
        assertThat(taskCampaign.getCampaign().hasGroup(), is(false));
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Campaign Group must be defined");
        service.activate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldNotAllowActivateWhenCampaignInCLOSEDState() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                                .with(createCampaignGroup())
                                .withState(CampaignState.CLOSED)
                ).build();
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("State Transition to ACTIVE not allowed");
        service.activate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldNotAllowActivateWhenCampaignInACTIVEState() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                                .with(createCampaignGroup())
                                .withState(CampaignState.ACTIVE)
                ).build();
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("State Transition to ACTIVE not allowed");
        service.activate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldActivate() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                                .with(createCampaignGroup())
                                .withState(CampaignState.NOT_ACTIVE)
                ).build();
        assertThat(taskCampaign.getCampaign().isActive(), is(false));
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        service.activate(TASK_CAMPAIGN_ID);

        assertThat(taskCampaign.getCampaign().isActive(), is(true));
    }


    @Test
    public void shouldNotAllowDeactivateWhenCampaignIsNull() {
        TaskCampaign taskCampaign = createTaskCampaign().build();
        assertThat(taskCampaign.getCampaign(), is(nullValue()));
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Campaign must be defined");
        service.deactivate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldNotAllowDeactivateWhenNoGroup() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                ).build();
        assertThat(taskCampaign.getCampaign().hasGroup(), is(false));
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Campaign Group must be defined");
        service.deactivate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldNotAllowDeactivateWhenCampaignInCLOSEDState() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                                .with(createCampaignGroup())
                                .withState(CampaignState.CLOSED)
                ).build();
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("State Transition to NOT_ACTIVE not allowed");
        service.deactivate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldNotAllowDeactivateWhenCampaignInNOT_ACTIVEState() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                                .with(createCampaignGroup())
                                .withState(CampaignState.NOT_ACTIVE)
                ).build();
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("State Transition to NOT_ACTIVE not allowed");
        service.deactivate(TASK_CAMPAIGN_ID);
    }

    @Test
    public void shouldDeactivate() {
        TaskCampaign taskCampaign = createTaskCampaign()
                .withCampaign(
                        createCampaign()
                                .with(createCampaignGroup())
                                .withState(CampaignState.ACTIVE)
                ).build();
        assertThat(taskCampaign.getCampaign().isActive(), is(true));
        doReturn(taskCampaign).when(entityRepository).getRequired(TaskCampaign.class, CAMPAIGN_ID);

        service.deactivate(TASK_CAMPAIGN_ID);

        assertThat(taskCampaign.getCampaign().isNotActive(), is(true));
    }

}

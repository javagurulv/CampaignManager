package lv.javaguru.campaignmanager.core.services;

import lv.javaguru.campaignmanager.core.commands.DomainCommand;
import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}

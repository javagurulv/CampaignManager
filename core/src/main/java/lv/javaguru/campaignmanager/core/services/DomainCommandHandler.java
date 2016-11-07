package lv.javaguru.campaignmanager.core.services;

import lv.javaguru.campaignmanager.core.commands.DomainCommand;
import lv.javaguru.campaignmanager.core.commands.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}

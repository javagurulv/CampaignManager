package lv.javaguru.campaignmanager.core;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}

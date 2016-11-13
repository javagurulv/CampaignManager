package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.DomainCommand;

public class UpdateClientCommand implements DomainCommand<UpdateClientResult> {

    private Long clientId;

    private String login;
    private String password;


    public UpdateClientCommand(Long clientId,
                               String login,
                               String password) {
        this.clientId = clientId;
        this.login = login;
        this.password = password;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}

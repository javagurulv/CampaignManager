package lv.javaguru.campaignmanager.core.commands.clients;

import lv.javaguru.campaignmanager.core.DomainCommand;

public class CreateClientCommand implements DomainCommand<CreateClientResult> {

    private String login;
    private String password;


    public CreateClientCommand(String login,
                               String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}

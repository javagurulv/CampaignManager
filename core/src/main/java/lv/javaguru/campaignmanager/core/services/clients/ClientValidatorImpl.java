package lv.javaguru.campaignmanager.core.services.clients;

import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

@Component
class ClientValidatorImpl implements ClientValidator {

    @Override
    public void validate(String login, String password) {
        validateLogin(login);
        validatePassword(password);
    }

    private void validateLogin(String login) {
        checkNotNull(login, "Client login must not be null");

    }

    private void validatePassword(String password) {
        checkNotNull(password, "Client password must not be null");

    }

}

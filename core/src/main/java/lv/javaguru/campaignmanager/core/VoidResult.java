package lv.javaguru.campaignmanager.core;

public class VoidResult implements DomainCommandResult {

    public static final VoidResult INSTANCE = new VoidResult();

    private VoidResult() {

    }

}

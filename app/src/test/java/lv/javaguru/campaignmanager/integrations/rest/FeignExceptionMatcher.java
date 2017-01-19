package lv.javaguru.campaignmanager.integrations.rest;

import feign.FeignException;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import javax.ws.rs.core.Response;

public class FeignExceptionMatcher extends BaseMatcher {

    private int responseStatusCode;

    public FeignExceptionMatcher(int responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    public static FeignExceptionMatcher createInternalServerErrorMatcher() {
        return new FeignExceptionMatcher(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Override
    public boolean matches(Object o) {
        return ((FeignException)o).status() == responseStatusCode;
    }

    @Override
    public void describeTo(Description description) {

    }
}

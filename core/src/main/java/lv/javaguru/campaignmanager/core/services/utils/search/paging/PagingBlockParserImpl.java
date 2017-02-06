package lv.javaguru.campaignmanager.core.services.utils.search.paging;

import lv.javaguru.campaignmanager.core.services.utils.search.ParsingException;
import lv.javaguru.campaignmanager.core.services.utils.search.model.SearchParameters;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
class PagingBlockParserImpl implements PagingBlockParser {

    private static final String REGEXP = "^\\{page:([0-9]+)\\}\\{page_size:([0-9]+)\\}$";

    private static final int PAGE_GROUP_NUMBER = 1;
    private static final int PAGE_SIZE_GROUP_NUMBER = 2;

    @Override
    public PagingBlock parse(SearchParameters parameters) {
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(parameters.getPaging());
        if (matcher.find()) {
            int page = Integer.parseInt(matcher.group(PAGE_GROUP_NUMBER));
            int pageSize = Integer.parseInt(matcher.group(PAGE_SIZE_GROUP_NUMBER));
            return new PagingBlock(page, pageSize);
        } else {
            throw new ParsingException("Incorrect paging section: " + parameters.getPaging());
        }
    }

}

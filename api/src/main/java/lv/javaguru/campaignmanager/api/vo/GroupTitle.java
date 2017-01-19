package lv.javaguru.campaignmanager.api.vo;

import org.springframework.util.StringUtils;

public class GroupTitle {

    private String title;

    public GroupTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isEmpty() {
        return StringUtils.isEmpty(title);
    }

}

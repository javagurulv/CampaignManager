package lv.javaguru.campaignmanager.core.vo;

import org.springframework.util.StringUtils;

public class GroupTitle {

    private String title;

    public GroupTitle(String title) {
        this.title = title;
    }

    public String get() {
        return title;
    }

    public boolean isEmpty() {
        return StringUtils.isEmpty(title);
    }

}

package lv.javaguru.campaignmanager.core.services.utils.search.paging;

public class PagingBlock {

    private int page;
    private int pageSize;

    public PagingBlock(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }
}

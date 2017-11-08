package to.ogarne.ogarneblog.web;

import org.springframework.data.domain.Pageable;

public class Pagination {
    Pageable pageable;
    Long itemCount;
    int pagesTotal;

    public Pagination(Pageable pageable, Long itemCount) {
        this.pageable = pageable;
        this.itemCount = itemCount;
        pagesTotal = (int) Math.ceil(itemCount / pageable.getPageSize());
    }



    public boolean isLast() {
        return !(pageable.getPageNumber() < pagesTotal);
    }

    public Pageable getPageable() {
        return pageable;
    }
}

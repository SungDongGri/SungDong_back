package SungDongGri.SungDong_back.base;


import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageResult<T> {
    int currentPage;
    int pageSize;
    int totalPage;
    Long totalCount;

    public PageResult(Page<T> data) {
        currentPage = data.getPageable().getPageNumber();
        pageSize = data.getPageable().getPageSize();
        totalPage = data.getTotalPages();
        totalCount = data.getTotalElements();
    }

    public static <T> PageResult<T> ok(Page<T> data) {
        return new PageResult<>(data);
    }
}

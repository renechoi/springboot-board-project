package kosta.boot.board.domain.pagination;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Data
@Component
public class Pagination {

    private ArticleSearchCondition searchCondition;
    private ArticleSortCondition sortCondition;

    private int articlesPerPage;
    private int pageCounts;

    private int currentPageNo;      // fetch (option)
    private int totalArticleCount;  // fetch
    private int totalPageCount;
    private int firstPage;
    private int lastPage;
    private int firstArticleIdx;
    private int lastArticleIdx;
    private boolean hasPreviousPage;
    private boolean hasNextPage;

    @Autowired
    public Pagination() {
        if (this.currentPageNo < 1) {
            this.currentPageNo = 1;
        }
        if (articlesPerPage< 1 || articlesPerPage > 100) {
            this.articlesPerPage = 10;
        }
        if (pageCounts < 5 || pageCounts > 20) {
            this.pageCounts = 10;
        }
    }

    public void setTotalArticleCount(int totalArticleCount) {
        this.totalArticleCount = totalArticleCount;

        if (totalArticleCount > 0) {
            createPageInfo();
        }
    }

    private void createPageInfo() {

        /* 전체 페이지 수 (현재 페이지 번호가 전체 페이지 수보다 크면 현재 페이지 번호에 전체 페이지 수를 저장) */
        totalPageCount = ((totalArticleCount - 1) / articlesPerPage) + 1;
        if (this.currentPageNo > totalPageCount) {
            this.currentPageNo = totalPageCount;
        }

        /* 페이지 리스트의 첫 페이지 번호 */
        firstPage = ((this.currentPageNo - 1) / pageCounts) * pageCounts + 1;

        /* 페이지 리스트의 마지막 페이지 번호 (마지막 페이지가 전체 페이지 수보다 크면 마지막 페이지에 전체 페이지 수를 저장) */
        lastPage = firstPage + pageCounts - 1;
        if (lastPage > totalPageCount) {
            lastPage = totalPageCount;
        }

        /* SQL의 조건절에 사용되는 첫 RNUM */
        firstArticleIdx = (this.currentPageNo - 1) * articlesPerPage;

        /* SQL의 조건절에 사용되는 마지막 RNUM */
        lastArticleIdx = this.currentPageNo * articlesPerPage;

        /* 이전 페이지 존재 여부 */
//        hasPreviousPage = firstPage != 1;
        hasPreviousPage = currentPageNo != 1;

        /* 다음 페이지 존재 여부 */
//        hasNextPage = (lastPage * articlesPerPage) < totalArticleCount;
        hasNextPage = currentPageNo != lastPage;
    }

    public String createQueryString(int pageNo) {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", articlesPerPage)
                .queryParam("pageSize", pageCounts)
                .queryParam("searchType", searchCondition.getSearchType())
                .queryParam("searchKeyword", searchCondition.getSearchKeyword())
                .queryParam("sortKeyword", sortCondition.getSortKeyword())
                .build()
                .encode();

        return uriComponents.toUriString();
    }

}
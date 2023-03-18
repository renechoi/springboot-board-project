package kosta.boot.board.domain.pagination;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArticleSearchCondition {

    private String searchKeyword;
    private String searchType;

}

package kosta.boot.board.domain.pagination;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArticleSortCondition {

    private String sortKeyword;
}

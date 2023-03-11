package kosta.springjspblog.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SearchCondition {
    private String keyword;
    private String condition;
}

package kosta.boot.board.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ArticleDto {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private String noticeYn;
    private String secretYn;
    //TODO : CommonDto로 상속 하는 것 고려
    private String deleteYn;  // TODO 변수명 변경 고려
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;

    private int userNo;
    private int userId;
    private String userName;

}


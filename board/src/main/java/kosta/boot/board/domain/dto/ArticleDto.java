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
    private String deletedYn;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;

    private int userNo;
    private int userId;
    private String userName;

}


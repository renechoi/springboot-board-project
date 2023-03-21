package kosta.boot.board.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long idx;
    private Long articleIdx;
    private String content;
    private String writer;

    private String deleteYn;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;

}

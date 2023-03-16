package kosta.boot.board.domain.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Board {
    private int no;
    private String title;
    private String content;
    private int hit;
    private LocalDateTime regDate;
    private int userNo;
    private String userName;

    private String writer;
    private long idx;
    private String deleteYn;
}
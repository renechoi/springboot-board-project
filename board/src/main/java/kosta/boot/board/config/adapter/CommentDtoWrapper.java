package kosta.boot.board.config.adapter;

import kosta.boot.board.domain.dto.CommentDto;

import java.util.List;

public class CommentDtoWrapper {
    private List<CommentDto> comments;

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}
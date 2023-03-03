package kosta.springjspblog.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Post {

	private int postNo;
	private int cateNo;
	private String postTitle;
	private String postContent;
	private String regDate;

}

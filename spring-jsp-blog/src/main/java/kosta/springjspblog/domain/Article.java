package kosta.springjspblog.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Article {

	private int articleNo;
	private int categoryNo;
	private String articleTitle;
	private String articleContent;
	private String regDate;

}

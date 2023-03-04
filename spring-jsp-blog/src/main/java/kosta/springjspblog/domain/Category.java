package kosta.springjspblog.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Category {

	private int cateNo;
	private String cateName;
	private String description;
	private String regDate;
	private int userNo;
	private int cnt;

}


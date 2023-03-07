package kosta.springjspblog.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Category {

	private int categoryNo;
	private String categoryName;
	private String categoryDescription;
	private String regDate;
	private String userId;
	private int cnt;

}


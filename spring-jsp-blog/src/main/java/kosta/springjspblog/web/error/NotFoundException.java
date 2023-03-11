package kosta.springjspblog.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "찾을 수 없는 페이지 입니다")
public class NotFoundException extends RuntimeException{
}



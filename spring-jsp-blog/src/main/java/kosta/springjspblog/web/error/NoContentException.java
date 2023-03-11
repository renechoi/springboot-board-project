package kosta.springjspblog.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "해당하는 블로그를 찾을 수 없습니다")
public class NoContentException extends RuntimeException{
}

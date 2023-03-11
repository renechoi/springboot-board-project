package kosta.springjspblog.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "불가한 접근 입니다")
public class ForbiddenException extends RuntimeException{
}

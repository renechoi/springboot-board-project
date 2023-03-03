package kosta.springjspblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {

    private int userNo;
    private String id;
    private String userName;
    private String password;
    private String joinDate;


}

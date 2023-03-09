package kosta.springjspblog.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Data
public class User {

    private int userNo;
    private String id;
    private String userName;
    private String password;
    private String joinDate;

    @Override
    public boolean equals(Object requestedUser) {
        if (this == requestedUser) return true;
        if (!(requestedUser instanceof User)) return false;
        User user = (User) requestedUser;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

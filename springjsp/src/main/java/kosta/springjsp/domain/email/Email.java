package kosta.springjsp.domain.email;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Email {

    private int no;
    private String lastName;
    private String firstName;
    private String email;

    public Email() {
    }

    public Email(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }
}

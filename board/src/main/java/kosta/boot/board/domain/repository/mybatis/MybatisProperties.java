//package kosta.boot.board.domain.repository.mybatis;
//
//
//import lombok.Getter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.ConstructorBinding;
//import org.springframework.validation.annotation.Validated;
//
//import javax.validation.constraints.NotEmpty;
//
//
//@Getter
//@ConfigurationProperties("my.datasource")
//@Validated
//public class MybatisProperties {
//
//    @NotEmpty
//    private String url;
//
//    @NotEmpty
//    private String username;
//
//    @NotEmpty
//    private String password;
//
//    @NotEmpty
//    private String driver;
//
//    public MybatisProperties(String url, String username, String password, String driver) {
//        this.url = url;
//        this.username = username;
//        this.password = password;
//        this.driver = driver;
//    }
//
//}
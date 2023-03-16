//package kosta.boot.board.domain.repository.mybatis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//
//@Slf4j
//@EnableConfigurationProperties(MybatisProperties.class)
//public class MybatisConfig {
//
//    private final MybatisProperties properties;
//
//    public MybatisConfig(MybatisProperties properties) {
//        this.properties = properties;
//    }
//
//    @Bean
//    public MybatisDataSource dataSource() {
//        return new MybatisDataSource(
//                properties.getUrl(),
//                properties.getUsername(),
//                properties.getPassword(),
//                properties.getDriver());
//    }
//}
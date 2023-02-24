package kosta.springjsp.config;


import kosta.springjsp.repository.mybatis.MyBatisItemRepository;
import kosta.springjsp.repository.ItemRepository;
import kosta.springjsp.repository.mybatis.ItemMapper;
import kosta.springjsp.service.EmailService;
import kosta.springjsp.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final ItemMapper itemMapper;

    @Bean
    public ItemService itemService() {
        return new EmailService(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }
}

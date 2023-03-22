package kosta.boot.board.config;

import kosta.boot.board.config.interceptors.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");
    }
//
//    @Bean
//    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
//        return new HiddenHttpMethodFilter();
//    }


//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JsonMixinModule());
//        return mapper;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter())
//                .create();
//
//        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter(gson);
//        converters.add(gsonHttpMessageConverter);
//    }
}


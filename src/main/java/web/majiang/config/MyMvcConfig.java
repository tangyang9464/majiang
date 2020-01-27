package web.majiang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import web.majiang.component.LoginHandlerInterceptor;
import web.majiang.component.MyLocaleResolver;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Bean//注册组件
    public WebMvcConfigurer webMvcConfigurer(){
       return  new WebMvcConfigurer() {
            //视图映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/test1.html").setViewName("test1");
                registry.addViewController("/publish.html").setViewName("publish");
            }

//            //拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).
//                        addPathPatterns("/**").
////                        excludePathPatterns("/static/**","/", "/index.html", "/index_test1");
//                        excludePathPatterns("/webjar/**","/", "/index.html", "/index_test1");
//            }
////           //第一个方法设置访问路径前缀，第二个方法设置资源路径
////           @Override
////           public void addResourceHandlers(ResourceHandlerRegistry registry) {
////               registry.addResourceHandler("/static/**").
////                       addResourceLocations("classpath:/static/");
////           }
       };
    }
    //国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

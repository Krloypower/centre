package rubbish.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rubbish.util.LogInterceptor;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;
    /**
     * 配置 xdcs 拦截器
     *
     * @param registry
     * @author chevn
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }
}

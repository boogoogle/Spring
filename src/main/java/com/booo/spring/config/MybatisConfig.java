package com.booo.spring.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                // 自动把小驼峰转换成大驼峰
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}

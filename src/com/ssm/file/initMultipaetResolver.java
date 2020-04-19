package com.ssm.file;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * @author 陈宜康
 * @date 2019/3/12 20:10
 * @forWhat
 */
public class initMultipaetResolver {
    @Bean(name = "multipartResolver")
    public MultipartResolver initMultipaetResolver() {
        return new StandardServletMultipartResolver();
    }
}

package com.hcl.hackton.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("api.interceptor")
public class ApiInterceptorProperties implements InitializingBean {


    private Boolean enable = false;

    private String[] exclude = new String[0];

    private String[] include = new String[0];

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("api interceptor properties loaded from config is :{}", this.toString());
    }
}

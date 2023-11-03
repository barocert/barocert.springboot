package com.barocert.springboot.autoconfigure;

import com.barocert.navercert.NavercertService;
import com.barocert.navercert.NavercertServiceImp;
import com.barocert.springboot.autoconfigure.properties.NavercertServiceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ConditionalOnClass(NavercertService.class)
@EnableConfigurationProperties({NavercertServiceProperties.class})
public class NavercertAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(NavercertAutoConfiguration.class);
    
    @Autowired
    private NavercertServiceProperties navercertServiceProperties;
    
    @Lazy
    @Bean(name = "NavercertService")
    @ConditionalOnMissingBean
    public NavercertService NavercertServiceConfig() {

        NavercertServiceImp navercertServiceImp = new NavercertServiceImp();

        navercertServiceImp.setLinkID(navercertServiceProperties.getLinkID());
        navercertServiceImp.setSecretKey(navercertServiceProperties.getSecretKey());
        navercertServiceImp.setUseStaticIP(navercertServiceProperties.isUseStaticIP());
        navercertServiceImp.setIPRestrictOnOff(navercertServiceProperties.isIsIPRestrictOnOff());
        navercertServiceImp.setServiceURL(navercertServiceProperties.getServiceURL());
        navercertServiceImp.setAuthURL(navercertServiceProperties.getAuthURL());

        logger.debug("NavercertService Initialized");

        return navercertServiceImp;
    }
}
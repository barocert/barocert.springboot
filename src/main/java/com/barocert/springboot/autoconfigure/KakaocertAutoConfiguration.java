package com.barocert.springboot.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.barocert.kakaocert.KakaocertService;
import com.barocert.kakaocert.KakaocertServiceImp;
import com.barocert.springboot.autoconfigure.properties.KakaocertServiceProperties;

@Configuration
@ConditionalOnClass(KakaocertService.class)
@EnableConfigurationProperties({KakaocertServiceProperties.class})
public class KakaocertAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(KakaocertAutoConfiguration.class);
    
    @Autowired
    private KakaocertServiceProperties kakaocertServiceProperties;
    
    @Lazy
    @Bean(name = "KakaocertService")
    @ConditionalOnMissingBean
    public KakaocertService KakaocertServiceConfig() {

        KakaocertServiceImp kakaocertServiceImp = new KakaocertServiceImp();

        kakaocertServiceImp.setLinkID(kakaocertServiceProperties.getLinkID());
        kakaocertServiceImp.setSecretKey(kakaocertServiceProperties.getSecretKey());
        kakaocertServiceImp.setUseStaticIP(kakaocertServiceProperties.isUseStaticIP());
        kakaocertServiceImp.setIPRestrictOnOff(kakaocertServiceProperties.isIsIPRestrictOnOff());
        kakaocertServiceImp.setServiceURL(kakaocertServiceProperties.getServiceURL());
        kakaocertServiceImp.setAuthURL(kakaocertServiceProperties.getAuthURL());
        kakaocertServiceImp.setProxyIP(kakaocertServiceProperties.getProxyIP());
        kakaocertServiceImp.setProxyPort(kakaocertServiceProperties.getProxyPort());

        logger.debug("KakaocertService Initialized");

        return kakaocertServiceImp;
    }
}
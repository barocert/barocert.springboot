package com.kakaocert.springboot.autoconfigure;

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
import com.kakaocert.springboot.autoconfigure.properties.BarocertServiceProperties;

@Configuration
@ConditionalOnClass(KakaocertService.class)
@EnableConfigurationProperties({BarocertServiceProperties.class})
public class KakaocertAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(KakaocertAutoConfiguration.class);
    
    @Autowired
    private BarocertServiceProperties barocertServiceProperties;
    
    @Lazy
    @Bean(name = "KakaocertService")
    @ConditionalOnMissingBean
    public KakaocertService KakaocertServiceConfig() {

        KakaocertServiceImp kakaocertServiceImp = new KakaocertServiceImp();

        kakaocertServiceImp.setLinkID(barocertServiceProperties.getLinkID());
        kakaocertServiceImp.setSecretKey(barocertServiceProperties.getSecretKey());
        kakaocertServiceImp.setUseStaticIP(barocertServiceProperties.isUseStaticIP());
        kakaocertServiceImp.setIPRestrictOnOff(barocertServiceProperties.isIsIPRestrictOnOff());

        logger.debug("KakaocertService Initialized");

        return kakaocertServiceImp;
    }
}
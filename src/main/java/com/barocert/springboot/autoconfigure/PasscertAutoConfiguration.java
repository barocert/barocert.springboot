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

import com.barocert.passcert.PasscertService;
import com.barocert.passcert.PasscertServiceImp;
import com.barocert.springboot.autoconfigure.properties.PasscertServiceProperties;

@Configuration
@ConditionalOnClass(PasscertService.class)
@EnableConfigurationProperties({PasscertServiceProperties.class})
public class PasscertAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(PasscertAutoConfiguration.class);
    
    @Autowired
    private PasscertServiceProperties passcertServiceProperties;
    
    @Lazy
    @Bean(name = "PasscertService")
    @ConditionalOnMissingBean
    public PasscertService PasscertServiceConfig() {

        PasscertServiceImp passcertServiceImp = new PasscertServiceImp();

        passcertServiceImp.setLinkID(passcertServiceProperties.getLinkID());
        passcertServiceImp.setSecretKey(passcertServiceProperties.getSecretKey());
        passcertServiceImp.setUseStaticIP(passcertServiceProperties.isUseStaticIP());
        passcertServiceImp.setIPRestrictOnOff(passcertServiceProperties.isIsIPRestrictOnOff());
        passcertServiceImp.setServiceURL(passcertServiceProperties.getServiceURL());
        passcertServiceImp.setAuthURL(passcertServiceProperties.getAuthURL());

        logger.debug("PasscertService Initialized");

        return passcertServiceImp;
    }
}
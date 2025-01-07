package com.barocert.springboot.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kakaocert")
public class KakaocertServiceProperties {

    private String LinkID = null;
    private String SecretKey = null;
    private boolean IsIPRestrictOnOff = true;
    private boolean UseStaticIP = false;
    private boolean UseLocalTimeYN = true;
    private String serviceURL = null;
    private String authURL = null;
    private String proxyIP = null;
    private Integer proxyPort = null;


    public String getLinkID() {
        return LinkID;
    }

    public void setLinkID(String linkID) {
        LinkID = linkID;
    }

    public String getSecretKey() {
        return SecretKey;
    }

    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    public boolean isIsIPRestrictOnOff() {
        return IsIPRestrictOnOff;
    }

    public void setIsIPRestrictOnOff(boolean isIPRestrictOnOff) {
        IsIPRestrictOnOff = isIPRestrictOnOff;
    }

    public boolean isUseStaticIP() {
        return UseStaticIP;
    }

    public void setUseStaticIP(boolean useStaticIP) {
        UseStaticIP = useStaticIP;
    }

    public boolean isUseLocalTimeYN() {
        return UseLocalTimeYN;
    }

    public void setUseLocalTimeYN(boolean useLocalTimeYN) {
        UseLocalTimeYN = useLocalTimeYN;
    }

    public String getServiceURL() {
        return this.serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

    public String getAuthURL() {
        return this.authURL;
    }

    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

    public String getProxyIP() { return proxyIP; }

    public void setProxyIP(String proxyIP) { this.proxyIP = proxyIP; }

    public Integer getProxyPort() { return proxyPort; }

    public void setProxyPort(Integer proxyPort) { this.proxyPort = proxyPort; }
}

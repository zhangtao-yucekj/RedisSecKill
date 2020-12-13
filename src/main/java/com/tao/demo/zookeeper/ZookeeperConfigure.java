package com.tao.demo.zookeeper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongwm
 * @since 2020-10-25
 */
@ConfigurationProperties(prefix = "converge.zookeeper")
@Configuration
public class ZookeeperConfigure  {

    private static String authority;

    private static String address;

    public void setAddress(String address) {
        System.out.println("set address " + address);
        this.address = address;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public static String getAddress() {
        return address;
    }

    public static String getAuthority() {
        return authority;
    }
}

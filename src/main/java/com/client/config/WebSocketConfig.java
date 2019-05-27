package com.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 类 名 称：WebSocketConfig
 * 类 描 述：TODO
 * 创建时间：2019/5/27 10:27
 * 创建人：Mical
 */
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}

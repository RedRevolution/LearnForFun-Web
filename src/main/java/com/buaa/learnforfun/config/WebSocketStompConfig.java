package com.buaa.learnforfun.config;

import com.buaa.learnforfun.controller.Fore.Group.WebSocketController;
import com.buaa.learnforfun.service.GroupMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 编写一个WebSocketConfig配置类，注入对象ServerEndpointExporter
 * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
 */
@Configuration
public class WebSocketStompConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}


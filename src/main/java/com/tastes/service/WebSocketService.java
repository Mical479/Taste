package com.tastes.service;

import com.client.config.GetHttpSessionConfigurator;
import com.client.pojo.BussinessUser;
import com.client.pojo.OrderPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 类 名 称：WebSocketService
 * 类 描 述：TODO
 * 创建时间：2019/5/27 10:02
 * 创建人：Mical
 */
@Component
@ServerEndpoint(value = "/order/webSocket", configurator = GetHttpSessionConfigurator.class)
@Slf4j
public class WebSocketService {

    private Session session;
    private BussinessUser user;
    private static ConcurrentHashMap<BussinessUser, WebSocketService> webSockets = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        this.session = session;
        HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        BussinessUser myUser = (BussinessUser) httpSession.getAttribute("user");
        this.user = myUser;
        webSockets.put(myUser, this);
        log.info("【websocket消息】{}建立了新的连接，总数：{}",user.getNickName(), webSockets.size());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this.user);
        log.info("【websocket消息】{}连接断开，总数：{}", user.getNickName(), webSockets.size());
    }

    @OnMessage
    public void onMessage(String msg){
        log.info("【websocket消息】收到客户端发来的消息：{}", msg);
    }

    public void sendMessage(Object o, OrderPojo order){
        WebSocketService webSocketService = webSockets.get(o);
        try {
            webSocketService.session.getBasicRemote().sendObject(order);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }
}

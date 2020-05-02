package com.buaa.learnforfun.controller.Fore;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Component
@ServerEndpoint("/webSocket/{groupId}/{userId}")
public class WebSocketController {
    // 保存 组id->组成员 的映射关系
    private static ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();

    // 收到消息调用的方法，群成员发送消息
    @OnMessage
    public void onMessage(@PathParam("groupId") String groupId,
                          @PathParam("userId") String userId, String message) {
        //得到当前群的所有会话，也就是所有用户
        List<Session> sessionList = groupMemberInfoMap.get(groupId);
        // 遍历Session集合给每个会话发送文本消息
        sessionList.forEach(item -> {
            try {
                //todo.. 把userId+message封装到后台,并返回userName
                String userName = "";
                String text = userName + ": " + message;
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 建立连接调用的方法，群成员加入
     *
     * @param session 会话
     * @param groupId 群id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("groupId") String groupId) {
        //得到当前群的所有会话，也就是所有用户
        List<Session> sessionList = groupMemberInfoMap.get(groupId);
        if (sessionList == null) {
            sessionList = new ArrayList<>();
            groupMemberInfoMap.put(groupId, sessionList);
        }
        sessionList.add(session);
    }

    // 关闭连接调用的方法，群成员退出
    @OnClose
    public void onClose(Session session, @PathParam("groupId") String groupId) {
        List<Session> sessionList = groupMemberInfoMap.get(groupId);
        sessionList.remove(session);
    }

    // 传输消息错误调用的方法
    @OnError
    public void OnError(Throwable error) {
    }
}

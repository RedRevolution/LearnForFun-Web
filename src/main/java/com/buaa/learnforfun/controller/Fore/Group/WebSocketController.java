package com.buaa.learnforfun.controller.Fore.Group;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.buaa.learnforfun.entity.Group;
import com.buaa.learnforfun.entity.GroupMessage;
import com.buaa.learnforfun.service.GroupMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/webSocket/{groupId}")
public class WebSocketController {

    //参考博文，这里注入的时候只能注入static对象
    private static GroupMessageService groupMessageService;

    @Autowired
    public void setGroupMessageService(GroupMessageService groupMessageService) {
        WebSocketController.groupMessageService = groupMessageService;
    }

    private static ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();

    // 收到消息调用的方法，群成员发送消息
    @OnMessage
    public void onMessage(@PathParam("groupId") String groupId, String message) {
        JSONObject jsonObject = JSON.parseObject(message);
        String userId = (String) jsonObject.get("userId");
        String userName = (String) jsonObject.get("userName");
        String content = (String) jsonObject.get("content");
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setGroupId(groupId);
        groupMessage.setUserId(userId);
        groupMessage.setUserName(userName);
        groupMessage.setContent(content);
        groupMessageService.addGroupMessage(groupMessage);
        //得到当前群的所有会话，也就是所有用户
        List<Session> sessionList = groupMemberInfoMap.get(groupId);
        // 遍历Session集合给每个会话发送文本消息
        sessionList.forEach(item -> {
            try {
                String text = userName + ": " + content;
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

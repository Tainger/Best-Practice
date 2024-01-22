package com.best.practice.controller;

import com.best.practice.config.WebSocketServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2024/1/20 11:31 PM
 */

@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/websocket")
@RestController
public class MsgContoller {

    @Autowired
    private WebSocketServerConfig webSocketServerConfig;

    /**
     * web消息发送测试
     * @return
     */
    @GetMapping("/instance/message")
    public String page() throws IOException {
        webSocketServerConfig.sendMessage("hellp");
        return "websocket/chatpage";
    }

    /**
     * 回调接口,向客户端推送实时消息
     * @param params 消息数据结构
     * @param toUserId 发动到用户ID
     * @return
     * @throws IOException 异常
     */
    @RequestMapping(value="/push/{toUserId}", method=RequestMethod.POST)
    @ResponseBody
    public Map pushToWeb(@RequestBody Map params, @PathVariable String toUserId) throws IOException {
        String message = params.get("message").toString();
        WebSocketServerConfig.sendInfo(message,toUserId);
        Map returnMap = new HashMap();
        returnMap.put("code", 200);
        returnMap.put("msg", "成功发送消息");
        return returnMap;
    }
}



    

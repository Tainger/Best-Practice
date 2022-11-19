package com.redission.api;

import com.redission.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2022/5/30 12:34 下午
 */

@RestController()
@RequestMapping("/demo")
public class SelfInterface {


    @PostMapping("/say/hello")
    public Message get(@RequestBody Map<String, Object> requestBody){

        System.out.println("收到的参数是:"+ requestBody);
        return Message.success(requestBody);
    }


    @GetMapping("/say/hello1")
    public String get1(){
        return "hello";
    }



}



    

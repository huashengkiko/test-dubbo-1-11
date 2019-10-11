package kiko.yuri.controller;

import kiko.yuri.model.dto.MQDemoDTO;
import kiko.yuri.extension.web.Payload;
import kiko.yuri.service.MQDemoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo/mq")
@Payload
public class MQDemoController {

    @Autowired
    private MQDemoService service;

    @ApiOperation("发送一条消息")
    @PostMapping("message")
    public void send(@RequestBody MQDemoDTO dto) {
        service.produce(dto);
    }

}

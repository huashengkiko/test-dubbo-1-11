package kiko.yuri.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import kiko.yuri.api.DubboDemoRemoteServiceApi;
import kiko.yuri.api.model.PageDemo;
import kiko.yuri.api.model.dto.DubboDemoDTO;
import kiko.yuri.api.model.query.DubboDemoQuery;
import kiko.yuri.extension.web.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("demo/dubbo")
@Payload
public class DubboDemoController {

    @Reference(version = "1.0")
    private DubboDemoRemoteServiceApi service;

    @GetMapping("call")
    public PageDemo<DubboDemoDTO> listPage() {
        DubboDemoQuery query = new DubboDemoQuery();
        query.setSize(20);
        return service.listPage(query);
    }

    @HystrixCommand(fallbackMethod = "getFallback")
    @GetMapping("fallback")
    public DubboDemoDTO get() {
        return service.get("1");
    }

    public DubboDemoDTO getFallback() {
        return new DubboDemoDTO("1", "dubbo");
    }

}

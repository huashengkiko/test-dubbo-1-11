package kiko.yuri.service;

import kiko.yuri.model.dto.MQDemoDTO;

public interface MQDemoService {

    void produce(MQDemoDTO dto);

    void consume(MQDemoDTO dto);

}

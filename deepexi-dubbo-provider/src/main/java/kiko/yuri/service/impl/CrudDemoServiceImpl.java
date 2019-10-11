package kiko.yuri.service.impl;

import kiko.yuri.model.entity.CrudDemoDO;
import kiko.yuri.mapper.CrudDemoMapper;
import kiko.yuri.service.CrudDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudDemoServiceImpl implements CrudDemoService {

    @Autowired
    private CrudDemoMapper mapper;

    @Override
    public List<CrudDemoDO> listAll() {
        return mapper.selectList(null);
    }

}

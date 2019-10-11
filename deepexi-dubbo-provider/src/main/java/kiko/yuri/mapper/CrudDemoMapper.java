package kiko.yuri.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kiko.yuri.model.entity.CrudDemoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrudDemoMapper extends BaseMapper<CrudDemoDO> {

}

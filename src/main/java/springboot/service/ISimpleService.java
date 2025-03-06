package springboot.service;

import org.apache.ibatis.annotations.Param;
import springboot.dto.SimpleBbsDto;

import java.util.List;
import java.util.Map;

public interface ISimpleService {
    public List<SimpleBbsDto> list();
    public SimpleBbsDto view(String id);
    public int write(Map<String, String> map);
    public int delete(@Param("_id") String id);
    public int count();
}

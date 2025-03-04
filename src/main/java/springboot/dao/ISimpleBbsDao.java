package springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springboot.dto.SimpleBbsDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface ISimpleBbsDao {

    public List<SimpleBbsDto> listDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(Map<String, String> map);
    public int deleteDao(@Param("_id") String id);
    public int articleCount();
}

package springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import springboot.dto.SimpleBbsDto;

import java.util.List;

@Mapper
public interface ISimpleBbsDao {

    public List<SimpleBbsDto> listDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(String writer, String title, String content);
    public int deleteDao(String id);

}
